package me.luke.modules.system.repository;


import io.lettuce.core.dynamic.annotation.Param;
import me.luke.modules.system.domain.SysConst;
import me.luke.modules.system.domain.SysSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/**
* @author Zheng Jie
* @date 2019-03-25
*/
@SuppressWarnings("all")
public interface SysConstRepository extends JpaRepository<SysConst, Long>, JpaSpecificationExecutor<SysConst> {
    @Query(value = "select id,name,value,type,sort,enabled " +
            " from sys_const " +
            " where  type  = :type "  +
            " order by sort  ",nativeQuery = true)
    List<SysConst> findByType(@Param("type")String type);
}