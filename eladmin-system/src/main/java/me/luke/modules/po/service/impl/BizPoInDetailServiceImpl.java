package me.luke.modules.po.service.impl;

import me.luke.modules.po.domain.BizPoInDetail;
import me.luke.utils.ValidationUtil;
import me.luke.utils.FileUtil;
import me.luke.modules.po.repository.BizPoInDetailRepository;
import me.luke.modules.po.service.BizPoInDetailService;
import me.luke.modules.po.service.dto.BizPoInDetailDto;
import me.luke.modules.po.service.dto.BizPoInDetailQueryCriteria;
import me.luke.modules.po.service.mapper.BizPoInDetailMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
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
* @date 2020-04-18
*/
@Service
//@CacheConfig(cacheNames = "bizPoInDetail")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BizPoInDetailServiceImpl implements BizPoInDetailService {

    private final BizPoInDetailRepository bizPoInDetailRepository;

    private final BizPoInDetailMapper bizPoInDetailMapper;

    public BizPoInDetailServiceImpl(BizPoInDetailRepository bizPoInDetailRepository, BizPoInDetailMapper bizPoInDetailMapper) {
        this.bizPoInDetailRepository = bizPoInDetailRepository;
        this.bizPoInDetailMapper = bizPoInDetailMapper;
    }

    @Override
    //@Cacheable
    public Map<String,Object> queryAll(BizPoInDetailQueryCriteria criteria, Pageable pageable){
        Page<BizPoInDetail> page = bizPoInDetailRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(bizPoInDetailMapper::toDto));
    }

    @Override
    //@Cacheable
    public List<BizPoInDetailDto> queryAll(BizPoInDetailQueryCriteria criteria){
        return bizPoInDetailMapper.toDto(bizPoInDetailRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    //@Cacheable(key = "#p0")
    public BizPoInDetailDto findById(Long id) {
        BizPoInDetail bizPoInDetail = bizPoInDetailRepository.findById(id).orElseGet(BizPoInDetail::new);
        ValidationUtil.isNull(bizPoInDetail.getId(),"BizPoInDetail","id",id);
        return bizPoInDetailMapper.toDto(bizPoInDetail);
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public BizPoInDetailDto create(BizPoInDetail resources) {
       // Snowflake snowflake = IdUtil.createSnowflake(1, 1);
      //  resources.setId(snowflake.nextId());
        return bizPoInDetailMapper.toDto(bizPoInDetailRepository.save(resources));
    }

    @Override
    //@CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(BizPoInDetail resources) {
        BizPoInDetail bizPoInDetail = bizPoInDetailRepository.findById(resources.getId()).orElseGet(BizPoInDetail::new);
        ValidationUtil.isNull( bizPoInDetail.getId(),"BizPoInDetail","id",resources.getId());
        bizPoInDetail.copy(resources);
        bizPoInDetailRepository.save(bizPoInDetail);
    }

    @Override
    //@CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            bizPoInDetailRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<BizPoInDetailDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (BizPoInDetailDto bizPoInDetail : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("主表关联", bizPoInDetail.getHeadId());
            map.put("数量", bizPoInDetail.getQty());
            map.put("采购价", bizPoInDetail.getPrice());
            map.put("税率", bizPoInDetail.getRate());
            map.put("备注", bizPoInDetail.getRemark());
            map.put("删除标记", bizPoInDetail.getIsDelete());
            map.put("版本号", bizPoInDetail.getVersion());
            map.put("修改日期", bizPoInDetail.getUpdateTime());
            map.put("创建日期", bizPoInDetail.getCreateTime());
            map.put("企业代码", bizPoInDetail.getTopCompanyCode());

            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}