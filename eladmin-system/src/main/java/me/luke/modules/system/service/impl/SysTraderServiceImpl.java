package me.luke.modules.system.service.impl;

import me.luke.exception.BadRequestException;
import me.luke.modules.system.domain.SysStore;
import me.luke.modules.system.domain.SysTrader;
import me.luke.utils.ValidationUtil;
import me.luke.utils.FileUtil;
import me.luke.modules.system.repository.SysTraderRepository;
import me.luke.modules.system.service.SysTraderService;
import me.luke.modules.system.service.dto.SysTraderDto;
import me.luke.modules.system.service.dto.SysTraderQueryCriteria;
import me.luke.modules.system.service.mapper.SysTraderMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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

import java.util.*;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

/**
* @author lukeWang
* @date 2020-04-16
*/
@Service
@CacheConfig(cacheNames = "sysTrader")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SysTraderServiceImpl implements SysTraderService {

    private final SysTraderRepository sysTraderRepository;

    private final SysTraderMapper sysTraderMapper;

    public SysTraderServiceImpl(SysTraderRepository sysTraderRepository, SysTraderMapper sysTraderMapper) {
        this.sysTraderRepository = sysTraderRepository;
        this.sysTraderMapper = sysTraderMapper;
    }

    @Override
    @Cacheable
    public Map<String,Object> queryAll(SysTraderQueryCriteria criteria, Pageable pageable){
        Page<SysTrader> page = sysTraderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(sysTraderMapper::toDto));
    }

    @Override
    @Cacheable
    public List<SysTraderDto> queryAll(SysTraderQueryCriteria criteria){
        return sysTraderMapper.toDto(sysTraderRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    @Cacheable(key = "#p0")
    public SysTraderDto findById(Long id) {
        SysTrader sysTrader = sysTraderRepository.findById(id).orElseGet(SysTrader::new);
        ValidationUtil.isNull(sysTrader.getId(),"SysTrader","id",id);
        return sysTraderMapper.toDto(sysTrader);
    }

    @Override
  //  @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public SysTraderDto create(SysTrader resources) {
        return sysTraderMapper.toDto(sysTraderRepository.save(resources));
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class)
    public void update(SysTrader resources) {
        SysTrader sysTrader = sysTraderRepository.findById(resources.getId()).orElseGet(SysTrader::new);
        ValidationUtil.isNull( sysTrader.getId(),"SysTrader","id",resources.getId());
        if(!sysTrader.getVersion().equals(resources.getVersion()))   throw new BadRequestException("数据被其他用户修改，请重新获取数据修改!");
        resources.setVersion(resources.getVersion()==null?0:resources.getVersion() + 1);
        sysTrader.copy(resources);
        sysTraderRepository.save(sysTrader);
    }

    @Override
   @CacheEvict(allEntries = true)
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            Optional<SysTrader> sysTrader = sysTraderRepository.findById(id);
            sysTrader.ifPresent(o->{
                sysTrader.get().setIsDelete(true);
                sysTrader.get().setVersion(sysTrader.get().getVersion()==null?0:sysTrader.get().getVersion() + 1);
                sysTraderRepository.save(sysTrader.get());
            });
        //   sysTraderRepository.deleteById(id);
        }
    }

    @Override
    public void download(List<SysTraderDto> all, HttpServletResponse response) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();
        for (SysTraderDto sysTrader : all) {
            Map<String,Object> map = new LinkedHashMap<>();
            map.put("名称", sysTrader.getName());
            map.put("供应商", sysTrader.getSalerFlag());
            map.put("客户商", sysTrader.getBuyerFlag());
            map.put("帐期", sysTrader.getPeriod());
            map.put("信用额度", sysTrader.getCreditAmout());
            map.put("联系人", sysTrader.getContacter());
            map.put("电话", sysTrader.getTel());
            map.put("地址", sysTrader.getAddress());
            map.put("银行名称", sysTrader.getBankName());
            map.put("银行帐户", sysTrader.getBankAccout());
            map.put("备注", sysTrader.getRemark());
            map.put("启用状态", sysTrader.getEnabled());
            list.add(map);
        }
        FileUtil.downloadExcel(list, response);
    }
}