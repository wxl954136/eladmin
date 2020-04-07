package me.luke.modules.system.repository;

import com.sun.xml.internal.bind.v2.model.core.ID;
import me.luke.modules.system.domain.SysStore;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
* @author lukeWang
* @date 2020-04-03
*/
public interface SysStoreRepository extends JpaRepository<SysStore, Long>, JpaSpecificationExecutor<SysStore> {
    @Query(value = " select count(1) from sys_store  " +
            " where  id    <>  ?1 " +
            " and  is_delete  =0 " +
            " and  name=?2  " +
            " and  top_company_code =?3 " ,
            nativeQuery = true
    )
    int findByNameCount(Long id,String name,String top_company_code);
}