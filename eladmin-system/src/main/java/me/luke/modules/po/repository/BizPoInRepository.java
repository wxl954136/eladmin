package me.luke.modules.po.repository;

import me.luke.modules.po.domain.BizPoIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author lukeWang
* @date 2020-04-17
*/
public interface BizPoInRepository extends JpaRepository<BizPoIn, Long>, JpaSpecificationExecutor<BizPoIn> {
}