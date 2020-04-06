package me.luke.modules.system.service.impl;

import me.luke.modules.system.domain.SysStore;
import me.luke.utils.*;
import me.luke.modules.system.repository.SysStoreRepository;
import me.luke.modules.system.service.SysStoreService;
import me.luke.modules.system.service.dto.SysStoreDto;
import me.luke.modules.system.service.dto.SysStoreQueryCriteria;
import me.luke.modules.system.service.mapper.SysStoreMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
// 默认不使用缓存
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;

/**
* @author lukeWang
* @date 2020-04-03
*/
@Service
@CacheConfig(cacheNames = "sysStore")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysStoreServiceImpl implements SysStoreService {

    private final SysStoreRepository sysStoreRepository;

    private final SysStoreMapper sysStoreMapper;

    public SysStoreServiceImpl(SysStoreRepository sysStoreRepository, SysStoreMapper sysStoreMapper) {
        this.sysStoreRepository = sysStoreRepository;
        this.sysStoreMapper = sysStoreMapper;
    }

    @Override
    @Cacheable
    public Map<String,Object> queryAll(SysStoreQueryCriteria criteria, Pageable pageable){
        Page<SysStore> page = sysStoreRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(sysStoreMapper::toDto));
    }

    @Override
    @Cacheable
    public List<SysStoreDto> queryAll(SysStoreQueryCriteria criteria){
        return sysStoreMapper.toDto(sysStoreRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Cacheable(key = "#p0")
    public SysStoreDto findById(Long id) {
        SysStore sysStore = sysStoreRepository.findById(id).orElseGet(SysStore::new);
        ValidationUtil.isNull(sysStore.getId(),"SysStore","id",id);
        return sysStoreMapper.toDto(sysStore);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public SysStoreDto create(SysStore resources) {

        return sysStoreMapper.toDto(sysStoreRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(SysStore resources) {
        SysStore sysStore = sysStoreRepository.findById(resources.getId()).orElseGet(SysStore::new);
        ValidationUtil.isNull( sysStore.getId(),"SysStore","id",resources.getId());
        sysStore.copy(resources);
        sysStoreRepository.save(sysStore);
    }
    @Override
    @CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            sysStoreRepository.deleteById(id);
        }
    }
    @Override
    @CacheEvict(allEntries = true)
    public void deleteAll(Set<SysStoreDto> sysStoreDtos) {
        for(SysStoreDto sysStoreDto : sysStoreDtos){
            Optional<SysStore> sysStore = sysStoreRepository.findById(sysStoreDto.getId());
            sysStore.ifPresent(o->{
                sysStore.get().setIsDelete(true);
                sysStoreRepository.save(sysStore.get());
            });
        }
    }

    /*
        @Override
        @CacheEvict(allEntries = true)
        public void deleteAll(Long[] ids) {
            for (Long id : ids) {
                //sysStoreRepository.deleteById(id);
            }
        }
    */
    @Override
    public void download(List<SysStoreDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (SysStoreDto sysStore : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("uuid", sysStore.getKeywords());
            map.put("仓库名称", sysStore.getName());
            map.put("状态", sysStore.getEnabled());
            map.put("备注", sysStore.getRemark());
            map.put("删除标记", sysStore.getIsDelete());
            map.put("版本号", sysStore.getVersion());
            map.put("修改日期", sysStore.getUpdateTime());
            map.put("创建日期", sysStore.getCreateTime());
            map.put("企业代码", sysStore.getTopCompanyCode());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}