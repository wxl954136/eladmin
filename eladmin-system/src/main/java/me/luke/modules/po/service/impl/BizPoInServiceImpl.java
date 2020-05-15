package me.luke.modules.po.service.impl;

import cn.hutool.core.util.IdUtil;
import me.luke.exception.BadRequestException;
import me.luke.modules.po.domain.BizPoIn;
import me.luke.modules.po.domain.BizPoInDetail;
import me.luke.modules.po.domain.BizTradeSerialFlow;
import me.luke.modules.po.repository.BizPoInDetailRepository;
import me.luke.modules.po.repository.BizPoInRepository;
import me.luke.modules.po.service.BizPoInDetailService;
import me.luke.modules.po.service.BizPoInService;
import me.luke.modules.po.service.BizTradeSerialFlowService;
import me.luke.modules.po.service.dto.BizPoInDto;
import me.luke.modules.po.service.dto.BizPoInQueryCriteria;
import me.luke.modules.po.service.mapper.BizPoInMapper;
import me.luke.modules.utils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
 * @author lukeWang
 * @date 2020-04-17
 */
@Service
//@CacheConfig(cacheNames = "bizPoIn")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BizPoInServiceImpl implements BizPoInService {
    private static final Logger logger = LoggerFactory.getLogger(BizPoInServiceImpl.class);
    @Autowired
    private RedisUtils redisUtils;
    private BizPoInRepository bizPoInRepository;
    private final BizPoInDetailRepository bizPoInDetailRepository;
    private final BizPoInDetailService bizPoInDetailService;
    private final BizTradeSerialFlowService bizTradeSerialFlowService;
    private final BizPoInMapper bizPoInMapper;

    public BizPoInServiceImpl(BizPoInRepository bizPoInRepository, BizPoInDetailRepository bizPoInDetailRepository, BizPoInDetailService bizPoInDetailService, BizTradeSerialFlowService bizTradeSerialFlowService, BizPoInMapper bizPoInMapper) {
        this.bizPoInRepository = bizPoInRepository;
        this.bizPoInDetailRepository = bizPoInDetailRepository;
        this.bizPoInDetailService = bizPoInDetailService;
        this.bizTradeSerialFlowService = bizTradeSerialFlowService;
        this.bizPoInMapper = bizPoInMapper;
    }

    @Override
    //@Cacheable
    public Map<String, Object> queryAll(BizPoInQueryCriteria criteria, Pageable pageable) {
        Page<BizPoIn> page = bizPoInRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder), pageable);
        return PageUtil.toPage(page.map(bizPoInMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<BizPoInDto> queryAll(BizPoInQueryCriteria criteria) {
        return bizPoInMapper.toDto(bizPoInRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root, criteria, criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public BizPoInDto findById(Long id) {
        BizPoIn bizPoIn = bizPoInRepository.findById(id).orElseGet(BizPoIn::new);
        ValidationUtil.isNull(bizPoIn.getId(), "BizPoIn", "id", id);
        return bizPoInMapper.toDto(bizPoIn);
    }

    @Override
    public BizPoInDto findLastBizNote() {
        BizPoIn bizPoIn = bizPoInRepository.findLastBizNote();
        if (bizPoIn == null) return null;
        return bizPoInMapper.toDto(bizPoIn);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public BizPoInDto create(BizPoIn resources) {
        String bizNoPrefix = SystemUtil.getBizNoteNo(SysStatusEnum.BIZ_NOTE_TYPE_PO_PI.getValue());
        BizPoIn lastBizPoIn = bizPoInRepository.findLastBizNote();
        if (lastBizPoIn != null) {
            String tMaxBizNo = lastBizPoIn.getBizNo();
            int iSerial = Integer.parseInt(tMaxBizNo.split("-")[1]);
            DecimalFormat df = new DecimalFormat("0000");
            String sSerial = df.format(++iSerial);
            resources.setBizNo(bizNoPrefix + "-" + sSerial);  //单据编号
        } else {
            resources.setBizNo(bizNoPrefix + "-0001");  //单据编号
        }
        for (BizPoInDetail detail : resources.getBizPoInDetails()) {
            if (StringUtils.isEmpty(detail.getKeywords())) detail.setKeywords(IdUtil.simpleUUID());
            //lukeWang:本例做为范例，每个程序都防此无论前端是否给值
            detail.setVersion(0);
            detail.setTopCompanyCode(resources.getTopCompanyCode());
            detail.setBizPoIn(resources);
            if (null!=detail.getBizTradeSerialFlow()  && detail.getBizTradeSerialFlow().size() > 0)
            {
                detail.setBizTradeSerialFlow(getMadeBizTradeSerialFlowList(resources,detail,detail.getBizTradeSerialFlow()));
                bizTradeSerialFlowService.update(detail.getBizTradeSerialFlow());
            }
        }

      //lukeWang: 这里处理
        return bizPoInMapper.toDto(bizPoInRepository.save(resources));
    }


    //处理串号里面的数据
    public List<BizTradeSerialFlow> getMadeBizTradeSerialFlowList(BizPoIn head, BizPoInDetail detail, List<BizTradeSerialFlow> serialList){
        List<BizTradeSerialFlow> resultList = new ArrayList<>();
        for(BizTradeSerialFlow bizTradeSerialFlow : serialList)
        {
            bizTradeSerialFlow.setTopCompanyCode(head.getTopCompanyCode());
            bizTradeSerialFlow.setBizHeadKeywords(head.getKeywords());
            bizTradeSerialFlow.setBizDetailKeywords(detail.getKeywords());
            bizTradeSerialFlow.setBizDate(head.getBizDate());
            bizTradeSerialFlow.setBizType(head.getBizType());
            bizTradeSerialFlow.setTraderId(head.getSysTrader().getId());
            bizTradeSerialFlow.setStoreId(head.getSysStore().getId());
            bizTradeSerialFlow.setSkuId(detail.getSysSku().getId());
            //serial01/serial02/serial03使用自己的，不动
            bizTradeSerialFlow.setQty(detail.getQty());
            bizTradeSerialFlow.setPrice(detail.getPrice());
            bizTradeSerialFlow.setRate(detail.getRate());
            resultList.add(bizTradeSerialFlow);
        }
        return resultList;
    }
    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(BizPoIn resources) {
        BizPoIn bizPoIn = bizPoInRepository.findById(resources.getId()).orElseGet(BizPoIn::new);
        ValidationUtil.isNull(bizPoIn.getId(), "BizPoIn", "id", resources.getId());
        if (bizPoIn.getVersion() != resources.getVersion()) {
            throw new BadRequestException("该记录已经被他人修改!");
        }
        resources.setVersion(resources.getVersion() == null ? 0 : resources.getVersion() + 1);
        Map<String, List<BizPoInDetail>> resultMap = getPrepareData(bizPoIn, resources);

        bizPoInDetailService.update(resultMap.get("ADD"));
        bizPoInDetailService.update(resultMap.get("UPD"));
        bizPoInDetailService.update(resultMap.get("DEL"));

        bizPoInRepository.save(bizPoIn);
    }

    public Map<String,List<BizPoInDetail> > getPrepareData(BizPoIn oldContent,BizPoIn newContent){

        Map<String,List<BizPoInDetail>> dataCollect = new HashMap<>(3);
        dataCollect.put("ADD",new ArrayList<>());
        dataCollect.put("DEL",new ArrayList<>());
        dataCollect.put("UPD",new ArrayList<>());
        Map<Long,BizPoInDetail> newContentIds = new HashMap<>();
        //001:寻找新增记录:
        for (BizPoInDetail bizPoInDetail : newContent.getBizPoInDetails()){
            bizPoInDetail.setBizPoIn(newContent); //这样关联头表
            if (null == bizPoInDetail.getId() ||  bizPoInDetail.getId() < 0 ) {
                bizPoInDetail.setVersion(0);
                bizPoInDetail.setTopCompanyCode(oldContent.getTopCompanyCode());
                dataCollect.get("ADD").add(bizPoInDetail);
            }
            else {
                if (null != bizPoInDetail.getBizTradeSerialFlow() )
                {
                    System.out.println("lukeWang--这里处理串并整理号-------" + bizPoInDetail.getBizTradeSerialFlow().size());

                }
                newContentIds.put(bizPoInDetail.getId(),bizPoInDetail) ;
            }
        }
        //002:第二步根据现有DB数据筛选DEL,UPD
        for (BizPoInDetail bizPoInDetail : oldContent.getBizPoInDetails()){
            bizPoInDetail.setBizPoIn(newContent); //这样关联头表
            if (newContentIds.containsKey(bizPoInDetail.getId()))
            {
                BizPoInDetail _update = newContentIds.get(bizPoInDetail.getId());  //用于判断是否更新
                if (!_update.toString().equalsIgnoreCase(bizPoInDetail.toString()))
                {
                    _update.setVersion(_update.getVersion()==null?0:_update.getVersion() + 1);
                    dataCollect.get("UPD").add(_update);
                }
            }else {
                bizPoInDetail.setIsDelete(true);
                bizPoInDetail.setVersion(bizPoInDetail.getVersion()==null?0:bizPoInDetail.getVersion() + 1);
                dataCollect.get("DEL").add(bizPoInDetail);
            }
        }
        return  dataCollect;
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteAll(Set<BizPoInDto> bizPoInDtos){
        for(BizPoInDto  bizPoinDto : bizPoInDtos){
            Optional<BizPoIn> bizPoIn = bizPoInRepository.findById(bizPoinDto.getId());
            bizPoInDetailService.deleteAllByHeadId(bizPoIn.get().getId());
            bizPoIn.ifPresent(o->{
                bizPoIn.get().setIsDelete(true);
                bizPoIn.get().setVersion(bizPoIn.get().getVersion()==null?0:bizPoIn.get().getVersion() + 1);
                bizPoInRepository.save(bizPoIn.get());
            });
        }
    }

    @Override
    public void download(List<BizPoInDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (BizPoInDto bizPoIn : all) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("往来单位id", bizPoIn.getTraderId());
            map.put("仓库id", bizPoIn.getStoreId());
            map.put("备注", bizPoIn.getRemark());
            map.put("删除标记", bizPoIn.getIsDelete());
            map.put("版本号", bizPoIn.getVersion());
            map.put("修改日期", bizPoIn.getUpdateTime());
            map.put("创建日期", bizPoIn.getCreateTime());
            map.put("企业代码", bizPoIn.getTopCompanyCode());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}