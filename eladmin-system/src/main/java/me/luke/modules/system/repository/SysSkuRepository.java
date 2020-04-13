package me.luke.modules.system.repository;


import me.luke.modules.system.domain.SysSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
* @author Zheng Jie
* @date 2019-03-25
*/
@SuppressWarnings("all")
public interface SysSkuRepository extends JpaRepository<SysSku, Long>, JpaSpecificationExecutor<SysSku> {







}