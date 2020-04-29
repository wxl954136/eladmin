package me.luke.modules.system.service;


import me.luke.modules.system.domain.SysConst;

import java.util.List;

public interface SysConstService {
    List<SysConst> findByType(String type);
}
