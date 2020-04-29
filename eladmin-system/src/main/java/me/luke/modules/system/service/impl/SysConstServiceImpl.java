package me.luke.modules.system.service.impl;

import me.luke.modules.system.domain.SysConst;
import me.luke.modules.system.repository.SysConstRepository;
import me.luke.modules.system.service.SysConstService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@CacheConfig(cacheNames = "sysConst")
public class SysConstServiceImpl  implements SysConstService {
    private final SysConstRepository sysConstRepository;
    public SysConstServiceImpl(SysConstRepository  sysConstRepository){
        this.sysConstRepository  = sysConstRepository;
    }

    @Override
    @Cacheable
    public List<SysConst> findByType(String type) {
        return sysConstRepository.findByType(type);
    }
}
