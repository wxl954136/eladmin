package me.luke.modules.system.service.impl;

import me.luke.exception.BadRequestException;
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
    public SysStoreDto findByName(String name) {
        /*
        SysStore sysStore = sysStoreRepository.findByName(name).orElseGet(SysStore::new);
        ValidationUtil.isNull(sysStore.getId(),"SysStore","name",name);
        return sysStoreMapper.toDto(sysStore);

         */
        return null;
    }

    @Override
    public int findByNameCount(Long id,String name, String topCompanyCode) {
        int num = sysStoreRepository.findByNameCount(id,name,topCompanyCode);
        return num;
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public SysStoreDto create(SysStore resources) {
        int nameSameCount = sysStoreRepository.findByNameCount(-1l, resources.getName(), resources.getTopCompanyCode());
        if (nameSameCount > 0 )  throw new BadRequestException("相同的仓库名称已经存在，请修改仓库名称");
        return sysStoreMapper.toDto(sysStoreRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(SysStore resources) {
        SysStore sysStore = sysStoreRepository.findById(resources.getId()).orElseGet(SysStore::new);
        ValidationUtil.isNull( sysStore.getId(),"SysStore","id",resources.getId());
        if(!sysStore.getVersion().equals(resources.getVersion()))   throw new BadRequestException("数据被其他用户修改，请重新获取数据修改!");


        int nameSameCount = sysStoreRepository.findByNameCount(resources.getId(), resources.getName(), resources.getTopCompanyCode());
        if (nameSameCount > 0 )  throw new BadRequestException("相同的仓库名称已经存在，请修改仓库名称");
        resources.setVersion(resources.getVersion()==null?0:resources.getVersion() + 1);
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
                sysStore.get().setVersion(sysStore.get().getVersion()==null?0:sysStore.get().getVersion() + 1);
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
           // map.put("uuid", sysStore.getKeywords());
            map.put("仓库名称", sysStore.getName());
            map.put("状态", sysStore.getEnabled()?"启用":"禁用");
            map.put("备注", sysStore.getRemark());
            //map.put("删除标记", sysStore.getIsDelete());
            //map.put("版本号", sysStore.getVersion());
            map.put("修改日期", sysStore.getUpdateTime());
            map.put("创建日期", sysStore.getCreateTime());
            map.put("企业代码", sysStore.getTopCompanyCode());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}