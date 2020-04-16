package me.luke.modules.system.service.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import me.luke.annotation.Query;

/**
* @author lukeWang
* @date 2020-04-16
*/
@Data
public class SysTraderQueryCriteria {

    /**
     * 模糊
     */
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    /**
     * 精确
     */
    @Query
    private Boolean salerFlag;

    /**
     * 精确
     */
    @Query
    private Boolean buyerFlag;

    /**
     * 精确
     */
    @Query
    private Boolean enabled;
    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;

    @Query(type = Query.Type.EQUAL)
    private String topCompanyCode;
}