package me.luke.modules.po.repository;

import io.lettuce.core.dynamic.annotation.Param;
import me.luke.modules.po.domain.BizTradeSerialFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
* @author lukeWang
* @date 2020-05-05
*/
public interface BizTradeSerialFlowRepository extends JpaRepository<BizTradeSerialFlow, Long>, JpaSpecificationExecutor<BizTradeSerialFlow> {
    @Query(value = "select * from biz_trade_serial_flow  " +
            " where biz_detail_keywords = :bizDetailKeywords " +
            " and biz_type = :bizType " +
            " and is_delete = 0 " +
            " order by id ",
            nativeQuery = true)
    List<BizTradeSerialFlow> findByBizDetailKeywords(@Param("bizDetailKeywords") String bizDetailKeywords,@Param("bizType")String bizType);
}