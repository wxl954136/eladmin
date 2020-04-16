package me.luke.modules.system.repository;

import me.luke.modules.system.domain.SysTrader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author lukeWang
* @date 2020-04-16
*/
public interface SysTraderRepository extends JpaRepository<SysTrader, Long>, JpaSpecificationExecutor<SysTrader> {
}