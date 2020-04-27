package me.luke.modules.po.repository;

import me.luke.modules.po.domain.BizPoIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
* @author lukeWang
* @date 2020-04-17
*/
public interface BizPoInRepository extends JpaRepository<BizPoIn, Long>, JpaSpecificationExecutor<BizPoIn> {
    /**
     * 取当前公司最大的单据编号
     * @return /
     */

    @Query(value = "select * from  biz_po_in order by id desc limit 1 ",nativeQuery = true)
    BizPoIn findLastBizNote();



}