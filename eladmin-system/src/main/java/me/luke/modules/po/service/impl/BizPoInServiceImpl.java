package me.luke.modules.po.service.impl;

import cn.hutool.core.util.IdUtil;
import me.luke.modules.po.domain.BizPoIn;
import me.luke.modules.po.domain.BizPoInDetail;
import me.luke.modules.po.repository.BizPoInDetailRepository;
import me.luke.modules.po.repository.BizPoInRepository;
import me.luke.modules.po.service.BizPoInDetailService;
import me.luke.modules.po.service.BizPoInService;
import me.luke.modules.po.service.dto.BizPoInDto;
import me.luke.modules.po.service.dto.BizPoInQueryCriteria;
import me.luke.modules.po.service.mapper.BizPoInMapper;
import me.luke.utils.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
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
 * @date 2020-04-17
 */
@Service
//@CacheConfig(cacheNames = "bizPoIn")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BizPoInServiceImpl implements BizPoInService {
    private static final Logger logger = LoggerFactory.getLogger(BizPoInServiceImpl.class);
    private final BizPoInRepository bizPoInRepository;
    private final BizPoInDetailRepository bizPoInDetailRepository;
    private final BizPoInDetailService bizPoInDetailService;
    private final BizPoInMapper bizPoInMapper;

    public BizPoInServiceImpl(BizPoInRepository bizPoInRepository, BizPoInDetailRepository bizPoInDetailRepository, BizPoInDetailService bizPoInDetailService, BizPoInMapper bizPoInMapper) {
        this.bizPoInRepository = bizPoInRepository;
        this.bizPoInDetailRepository = bizPoInDetailRepository;
        this.bizPoInDetailService = bizPoInDetailService;
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
            detail.setKeywords(IdUtil.simpleUUID());
            //lukeWang:本例做为东西，每个程序都防此无论前端是否给值
            detail.setVersion(0);
            detail.setTopCompanyCode(resources.getTopCompanyCode());
            detail.setBizPoIn(resources);
        }
        return bizPoInMapper.toDto(bizPoInRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(BizPoIn resources) {
        BizPoIn bizPoIn = bizPoInRepository.findById(resources.getId()).orElseGet(BizPoIn::new);
        ValidationUtil.isNull(bizPoIn.getId(), "BizPoIn", "id", resources.getId());
        bizPoIn.copy(resources);
        // bizPoInDetailRepository.save(bizPoIn.getBizPoInDetails());
        for (BizPoInDetail detail : resources.getBizPoInDetails()) {
            logger.info("lukeWang:新增采购记录记录--------");
            detail.setKeywords(IdUtil.simpleUUID());
            detail.setBizPoIn(resources);
            detail.copy(detail);  //使其给到类序列化对象
            if (null == detail.getId() || detail.getId() <= 0) {
                bizPoInDetailService.create(detail);
            } else {
                bizPoInDetailService.update(detail);
            }
            //  bizPoInDetailRepository.save(detail);

        }
        bizPoInRepository.save(bizPoIn);

    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            bizPoInRepository.deleteById(id);
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