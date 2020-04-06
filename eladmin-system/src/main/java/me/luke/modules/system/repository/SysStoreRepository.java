package me.luke.modules.system.repository;

import com.sun.xml.internal.bind.v2.model.core.ID;
import me.luke.modules.system.domain.SysStore;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
* @author lukeWang
* @date 2020-04-03
*/
public interface SysStoreRepository extends JpaRepository<SysStore, Long>, JpaSpecificationExecutor<SysStore> {

}