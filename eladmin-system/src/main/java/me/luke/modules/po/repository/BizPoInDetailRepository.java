package me.luke.modules.po.repository;

import me.luke.modules.po.domain.BizPoInDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author lukeWang
* @date 2020-04-18
*/
public interface BizPoInDetailRepository extends JpaRepository<BizPoInDetail, Long>, JpaSpecificationExecutor<BizPoInDetail> {
}