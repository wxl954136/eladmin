package me.luke.modules.system.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.luke.modules.system.domain.SysSku;

import me.luke.modules.system.domain.vo.Assist;
import me.luke.modules.system.repository.SysSkuRepository;
import me.luke.modules.system.service.SysSkuService;
import me.luke.modules.system.service.dto.SysSkuDto;
import me.luke.modules.system.service.dto.SysSkuQueryCriteria;
import me.luke.modules.system.service.mapper.SysSkuMapper;
import me.luke.utils.*;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
* @author lukeWang
* @date 20120-03-25
*/
@Slf4j
@Service
@CacheConfig(cacheNames = "sysSku")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysSkuServiceImpl implements SysSkuService {

    private final SysSkuRepository sysSkuRepository;

    private final SysSkuMapper sysSkuMapper;

    @PersistenceContext
    private EntityManager em;


    public SysSkuServiceImpl(SysSkuRepository sysSkuRepository, SysSkuMapper sysSkuMapper) {
        this.sysSkuRepository = sysSkuRepository;
        this.sysSkuMapper = sysSkuMapper;
    }

    @Override
    @Cacheable
    public List<SysSkuDto> queryAll(SysSkuQueryCriteria criteria) {
        return sysSkuMapper.toDto(sysSkuRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Cacheable
    public List<Assist> findAllByBrand(String ... data) {
        try{
            List<Object[]> result = sysSkuRepository.findAllByBrand(data);
            List<Assist> resultView = CastEntity.castEntity(result, Assist.class);
            return resultView;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    @Cacheable
    public List<Assist> findAllByColor(String ... data) {
        try{
            List<Object[]> result = sysSkuRepository.findAllByColor(data);
            List<Assist> resultView = CastEntity.castEntity(result, Assist.class);
            return resultView;
        }catch (Exception e){
            return null;
        }
      //  return sysSkuRepository.findAllByColor(data);
    }

    @Override
    @Cacheable
    public Map<String,Object> queryAll(SysSkuQueryCriteria criteria, Pageable pageable){
        Page<SysSku> page = sysSkuRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(sysSkuMapper::toDto));
}

    @Override
    @Cacheable(key = "#p0")
    public SysSkuDto findById(Long id) {
        SysSku classify = sysSkuRepository.findById(id).orElseGet(SysSku::new);
        ValidationUtil.isNull(classify.getId(),"SysSku","id",id);
        return sysSkuMapper.toDto(classify);
    }



    @Override
    @CacheEvict(allEntries = true)   //清除缓存，重新注入
    @Transactional(rollbackFor = Exception.class)
    public SysSkuDto create(SysSku resources) {

        return sysSkuMapper.toDto(sysSkuRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(SysSku resources) {
        sysSkuRepository.save(resources);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<SysSkuDto> sysSkuClassifyDtos) {
        for (SysSkuDto sysSkuClassifyDto : sysSkuClassifyDtos) {
            Optional<SysSku> sysSku = sysSkuRepository.findById(sysSkuClassifyDto.getId());
            sysSku.ifPresent(o->{
                sysSku.get().setIsDelete(true);
                sysSkuRepository.save(sysSku.get());
             //   throw new BadRequestException("禁止删除");
            });
        }
    }
    public void deleteAll(Set<SysSkuDto> sysSkuDtos) {
        for(SysSkuDto sysSkuDto : sysSkuDtos){
            Optional<SysSku> sysSku = sysSkuRepository.findById(sysSkuDto.getId());
            sysSku.ifPresent(o->{
                sysSku.get().setIsDelete(true);
                sysSku.get().setVersion(sysSku.get().getVersion()==null?0:sysSku.get().getVersion() + 1);
                sysSkuRepository.save(sysSku.get());
            });
        }
    }
    @Override
    public void download(List<SysSkuDto> sysSkuClassifyDtosDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (SysSkuDto skuDto : sysSkuClassifyDtosDtos) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("商品分类", skuDto.getName());
            map.put("商品分类全称", skuDto.getFullName());
            map.put("状态", skuDto.getEnabled() ? "启用" : "停用");
            map.put("创建日期", skuDto.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }




}