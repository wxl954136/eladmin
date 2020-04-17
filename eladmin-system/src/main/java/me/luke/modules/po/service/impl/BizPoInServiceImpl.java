package me.luke.modules.po.service.impl;

import me.luke.modules.po.domain.BizPoIn;
import me.luke.utils.ValidationUtil;
import me.luke.utils.FileUtil;
import me.luke.modules.po.repository.BizPoInRepository;
import me.luke.modules.po.service.BizPoInService;
import me.luke.modules.po.service.dto.BizPoInDto;
import me.luke.modules.po.service.dto.BizPoInQueryCriteria;
import me.luke.modules.po.service.mapper.BizPoInMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
// 默认不使用缓存
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import me.luke.utils.PageUtil;
import me.luke.utils.QueryHelp;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
* @author lukeWang
* @date 2020-04-17
*/
@Service
//@CacheConfig(cacheNames = "bizPoIn")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BizPoInServiceImpl implements BizPoInService {

    private final BizPoInRepository bizPoInRepository;

    private final BizPoInMapper bizPoInMapper;

    public BizPoInServiceImpl(BizPoInRepository bizPoInRepository, BizPoInMapper bizPoInMapper) {
        this.bizPoInRepository = bizPoInRepository;
        this.bizPoInMapper = bizPoInMapper;
    }

    @Override
    //@Cacheable
    public Map<String,Object> queryAll(BizPoInQueryCriteria criteria, Pageable pageable){
        Page<BizPoIn> page = bizPoInRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(bizPoInMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<BizPoInDto> queryAll(BizPoInQueryCriteria criteria){
        return bizPoInMapper.toDto(bizPoInRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public BizPoInDto findById(Long id) {
        BizPoIn bizPoIn = bizPoInRepository.findById(id).orElseGet(BizPoIn::new);
        ValidationUtil.isNull(bizPoIn.getId(),"BizPoIn","id",id);
        return bizPoInMapper.toDto(bizPoIn);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public BizPoInDto create(BizPoIn resources) {
        return bizPoInMapper.toDto(bizPoInRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(BizPoIn resources) {
        BizPoIn bizPoIn = bizPoInRepository.findById(resources.getId()).orElseGet(BizPoIn::new);
        ValidationUtil.isNull( bizPoIn.getId(),"BizPoIn","id",resources.getId());
        bizPoIn.copy(resources);
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
            Map<String,Object> map = new LinkedHashMap<>();
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