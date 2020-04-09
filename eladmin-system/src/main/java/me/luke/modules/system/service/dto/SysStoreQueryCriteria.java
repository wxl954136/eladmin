package me.luke.modules.system.service.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import me.luke.annotation.Query;

/**
* @author lukeWang
* @date 2020-04-03
*/
@Data
public class SysStoreQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query(propName = "id", type = Query.Type.IN, joinName = "dept")
    private Set<Long> deptIds;
    /** 精确 */
    @Query
    private Boolean enabled;

    @Query(type = Query.Type.EQUAL)
    private Boolean isDelete;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;

    @Query(propName = "id", joinName = "dept")
    private Long deptId;

    @Query(type = Query.Type.EQUAL)
    private String topCompanyCode;



}