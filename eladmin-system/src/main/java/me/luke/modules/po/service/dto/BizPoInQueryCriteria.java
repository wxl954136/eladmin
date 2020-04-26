package me.luke.modules.po.service.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import me.luke.annotation.Query;

/**
* @author lukeWang
* @date 2020-04-17
*/
@Data
public class BizPoInQueryCriteria{
    @Query(type = Query.Type.IN, propName="id")
    private Set<Long> ids;

    @Query(type = Query.Type.INNER_LIKE)
    private String noteNo;

    @Query(type = Query.Type.EQUAL)
    private Integer status;

    @Query(type = Query.Type.BETWEEN)
    private List<String> bizDate;

    @Query(propName = "id", joinName = "trader")
    private Long traderId;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}