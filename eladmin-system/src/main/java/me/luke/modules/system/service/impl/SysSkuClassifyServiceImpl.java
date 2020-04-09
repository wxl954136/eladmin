package me.luke.modules.system.service.impl;

import lombok.extern.slf4j.Slf4j;
import me.luke.exception.BadRequestException;
import me.luke.modules.system.domain.SysSkuClassify;
import me.luke.modules.system.repository.SysSkuClassifyRepository;
import me.luke.modules.system.service.SysSkuClassifyService;
import me.luke.modules.system.service.dto.SysSkuClassifyDto;
import me.luke.modules.system.service.dto.SysSkuClassifyQueryCriteria;
import me.luke.modules.system.service.mapper.SysSkuClassifyMapper;
import me.luke.utils.FileUtil;
import me.luke.utils.QueryHelp;
import me.luke.utils.ValidationUtil;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
* @author lukeWang
* @date 20120-03-25
*/
@Slf4j
@Service
@CacheConfig(cacheNames = "sysSkuClassify")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysSkuClassifyServiceImpl implements SysSkuClassifyService {

    private final SysSkuClassifyRepository sysSkuClassifyRepository;

    private final SysSkuClassifyMapper sysSkuClassifyMapper;




    public SysSkuClassifyServiceImpl(SysSkuClassifyRepository sysSkuClassifyRepository, SysSkuClassifyMapper sysSkuClassifyMapper) {
        this.sysSkuClassifyRepository = sysSkuClassifyRepository;
        this.sysSkuClassifyMapper = sysSkuClassifyMapper;
    }

    @Override
    @Cacheable
    public List<SysSkuClassifyDto> queryAll(SysSkuClassifyQueryCriteria criteria) {
        return sysSkuClassifyMapper.toDto(sysSkuClassifyRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }
    @Override
    @Cacheable(key = "#p0")
    public SysSkuClassifyDto findById(Long id) {
        SysSkuClassify classify = sysSkuClassifyRepository.findById(id).orElseGet(SysSkuClassify::new);
        ValidationUtil.isNull(classify.getId(),"SysSkuClassify","id",id);
        return sysSkuClassifyMapper.toDto(classify);
    }

    @Override
    @Cacheable
    public List<SysSkuClassify> findByPid(long pid) {
        return sysSkuClassifyRepository.findByPid(pid);
    }


    @Override
    @Cacheable
    public Object buildTree(List<SysSkuClassifyDto> classsifyDtos) {
        Set<SysSkuClassifyDto> trees = new LinkedHashSet<>();
        Set<SysSkuClassifyDto> classifys= new LinkedHashSet<>();
        List<String> classifyNames = classsifyDtos.stream().map(SysSkuClassifyDto::getName).collect(Collectors.toList());
        boolean isChild;
        for (SysSkuClassifyDto classifyDTO : classsifyDtos) {
            isChild = false;
            if ("0".equals(classifyDTO.getPid().toString())) {
                trees.add(classifyDTO);
            }
            for (SysSkuClassifyDto it : classsifyDtos) {
                if (it.getPid().equals(classifyDTO.getId())) {
                    isChild = true;
                    if (classifyDTO.getChildren() == null) {
                        classifyDTO.setChildren(new ArrayList<>());
                    }
                    classifyDTO.getChildren().add(it);
                }
            }
            if(isChild) {
                classifys.add(classifyDTO);
            } else if(!classifyNames.contains(sysSkuClassifyRepository.findNameById(classifyDTO.getPid()))) {
                classifys.add(classifyDTO);
            }
        }

        if (CollectionUtils.isEmpty(trees)) {
            trees = classifys;
        }

        Integer totalElements = classifys.size();

        Map<String,Object> map = new HashMap<>(2);
        map.put("totalElements",totalElements);
        map.put("content",CollectionUtils.isEmpty(trees)? classifys :trees);
        return map;
    }

    @Override
    @CacheEvict(allEntries = true)   //清除缓存，重新注入
    @Transactional(rollbackFor = Exception.class)
    public SysSkuClassifyDto create(SysSkuClassify resources) {
        Optional<SysSkuClassify> sysSkuClassify = sysSkuClassifyRepository.findById(resources.getPid());
        sysSkuClassify.ifPresent(o->{
            resources.setFullName(sysSkuClassify.get().getFullName() + "." + resources.getName());
        });
        return sysSkuClassifyMapper.toDto(sysSkuClassifyRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(SysSkuClassify resources) {
        if(resources.getId().equals(resources.getPid())) {
            throw new BadRequestException("上级不能为自己");
        }
        SysSkuClassify sysSkuClassify = sysSkuClassifyRepository.findById(resources.getId()).orElseGet(SysSkuClassify::new);
        ValidationUtil.isNull( sysSkuClassify.getId(),"SysSkuClassify","id",resources.getId());
        resources.setId(sysSkuClassify.getId());
        sysSkuClassifyRepository.save(resources);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void delete(Set<SysSkuClassifyDto> sysSkuClassifyDtos) {
        for (SysSkuClassifyDto sysSkuClassifyDto : sysSkuClassifyDtos) {
            Optional<SysSkuClassify> sysSkuClassify = sysSkuClassifyRepository.findById(sysSkuClassifyDto.getId());
            sysSkuClassify.ifPresent(o->{
                sysSkuClassify.get().setIsDelete(true);
                sysSkuClassifyRepository.save(sysSkuClassify.get());

             //   throw new BadRequestException("禁止删除");
            });
        }
    }
    @Override
    public void download(List<SysSkuClassifyDto> sysSkuClassifyDtosDtos, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (SysSkuClassifyDto sysSkuClassifyDTO : sysSkuClassifyDtosDtos) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("商品分类", sysSkuClassifyDTO.getName());
            map.put("商品分类全称", sysSkuClassifyDTO.getFullName());
            map.put("状态", sysSkuClassifyDTO.getEnabled() ? "启用" : "停用");
            map.put("创建日期", sysSkuClassifyDTO.getCreateTime());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }

    @Override
    public Set<SysSkuClassifyDto> getDeleteSysSkuClassifys(List<SysSkuClassify> menuList, Set<SysSkuClassifyDto> classifyDtos) {
        for (SysSkuClassify classify : menuList) {
            classifyDtos.add(sysSkuClassifyMapper.toDto(classify));
            List<SysSkuClassify> classifys = sysSkuClassifyRepository.findByPid(classify.getId());
            if(classifys!=null && classifys.size()!=0){
                getDeleteSysSkuClassifys(classifys, classifyDtos);
            }
        }
        return classifyDtos;
    }


}