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
public class SysSkuQueryCriteria {

    @Query(type = Query.Type.IN, propName="id")
    private Set<Long> ids;

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query(blurry = "code,mnemonic_code,pinyin,full_name")  //这里要加拼音
    private String blurry;

    @Query(propName = "id", type = Query.Type.IN, joinName = "sysSkuClassify")
    private Set<Long> classifyIds;

    @Query(propName = "id", joinName = "sysSkuClassify")
    private Long classifyId;
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