package me.zhengjie.modules.system.repository;

import me.zhengjie.modules.system.domain.SysStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author lukeWang
* @date 2020-04-03
*/
public interface SysStoreRepository extends JpaRepository<SysStore, Long>, JpaSpecificationExecutor<SysStore> {
}