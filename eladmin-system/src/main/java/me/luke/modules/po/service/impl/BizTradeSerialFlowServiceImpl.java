package me.luke.modules.po.service.impl;

import me.luke.modules.po.domain.BizTradeSerialFlow;
import me.luke.modules.po.repository.BizTradeSerialFlowRepository;
import me.luke.modules.po.service.BizTradeSerialFlowService;
import me.luke.modules.po.service.dto.BizTradeSerialFlowDto;
import me.luke.modules.po.service.dto.BizTradeSerialFlowQueryCriteria;
import me.luke.modules.po.service.mapper.BizTradeSerialFlowMapper;
import me.luke.utils.FileUtil;
import me.luke.utils.PageUtil;
import me.luke.utils.QueryHelp;
import me.luke.utils.ValidationUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;

/**
* @author lukeWang
* @date 2020-05-05
*/
@Service
//@CacheConfig(cacheNames = "bizTradeSerialFlow")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BizTradeSerialFlowServiceImpl implements BizTradeSerialFlowService {

    private final BizTradeSerialFlowRepository bizTradeSerialFlowRepository;

    private final BizTradeSerialFlowMapper bizTradeSerialFlowMapper;

    public BizTradeSerialFlowServiceImpl(BizTradeSerialFlowRepository bizTradeSerialFlowRepository, BizTradeSerialFlowMapper bizTradeSerialFlowMapper) {
        this.bizTradeSerialFlowRepository = bizTradeSerialFlowRepository;
        this.bizTradeSerialFlowMapper = bizTradeSerialFlowMapper;
    }

    @Override
    //@Cacheable
    public Map<String,Object> queryAll(BizTradeSerialFlowQueryCriteria criteria, Pageable pageable){
        Page<BizTradeSerialFlow> page = bizTradeSerialFlowRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(bizTradeSerialFlowMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<BizTradeSerialFlowDto> queryAll(BizTradeSerialFlowQueryCriteria criteria){
        return bizTradeSerialFlowMapper.toDto(bizTradeSerialFlowRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public BizTradeSerialFlowDto findById(Long id) {
        BizTradeSerialFlow bizTradeSerialFlow = bizTradeSerialFlowRepository.findById(id).orElseGet(BizTradeSerialFlow::new);
        ValidationUtil.isNull(bizTradeSerialFlow.getId(),"BizTradeSerialFlow","id",id);
        return bizTradeSerialFlowMapper.toDto(bizTradeSerialFlow);
    }

    @Override
    public List<BizTradeSerialFlowDto> findByBizDetailKeywords(String  bizDetailKeywords,String bizType) {
        List<BizTradeSerialFlow> listBizTradeSerialFlow = bizTradeSerialFlowRepository.findByBizDetailKeywords(bizDetailKeywords,bizType);
        return bizTradeSerialFlowMapper.toDto(listBizTradeSerialFlow);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public BizTradeSerialFlowDto create(BizTradeSerialFlow resources) {
        return bizTradeSerialFlowMapper.toDto(bizTradeSerialFlowRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(BizTradeSerialFlow resources) {
        BizTradeSerialFlow bizTradeSerialFlow = bizTradeSerialFlowRepository.findById(resources.getId()).orElseGet(BizTradeSerialFlow::new);
        ValidationUtil.isNull( bizTradeSerialFlow.getId(),"BizTradeSerialFlow","id",resources.getId());
        bizTradeSerialFlow.copy(resources);
        bizTradeSerialFlowRepository.save(bizTradeSerialFlow);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            bizTradeSerialFlowRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<BizTradeSerialFlowDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (BizTradeSerialFlowDto bizTradeSerialFlow : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("uuid", bizTradeSerialFlow.getKeywords());


            map.put("业务单据日期", bizTradeSerialFlow.getBizDate());
            map.put("单据类型", bizTradeSerialFlow.getBizType());
            map.put("往来单位id", bizTradeSerialFlow.getTraderId());
            map.put("仓库id", bizTradeSerialFlow.getStoreId());
            map.put("商品id", bizTradeSerialFlow.getSkuId());
            map.put("串号01", bizTradeSerialFlow.getSerial01());
            map.put("串号02", bizTradeSerialFlow.getSerial02());
            map.put("串号03", bizTradeSerialFlow.getSerial03());
            map.put("数量", bizTradeSerialFlow.getQty());
            map.put("单价", bizTradeSerialFlow.getPrice());
            map.put("税率", bizTradeSerialFlow.getRate());
            map.put("删除标记", bizTradeSerialFlow.getIsDelete());
            map.put("版本号", bizTradeSerialFlow.getVersion());
            map.put("修改日期", bizTradeSerialFlow.getUpdateTime());
            map.put("创建日期", bizTradeSerialFlow.getCreateTime());
            map.put("企业代码", bizTradeSerialFlow.getTopCompanyCode());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}