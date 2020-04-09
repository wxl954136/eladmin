package me.luke.modules.system.service.dto;

import lombok.Data;
import me.luke.annotation.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Data
public class SysSkuClassifyQueryCriteria {

    @Query(type = Query.Type.IN, propName="id")
    private Set<Long> ids;

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query(blurry = "name")  //这里要加拼音
    private String blurry;

    @Query
    private Boolean enabled;

    @Query
    private Long pid;

    @Query(type = Query.Type.EQUAL)
    private Boolean isDelete;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;



    @Query(type = Query.Type.EQUAL)
    private String topCompanyCode;
}