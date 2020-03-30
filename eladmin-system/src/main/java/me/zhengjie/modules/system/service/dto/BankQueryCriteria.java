package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import me.zhengjie.annotation.Query;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
* @author Zheng Jie
* @date 2019-6-4 14:49:34
*/
@Data
@NoArgsConstructor
public class BankQueryCriteria {
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    @Query(type = Query.Type.INNER_LIKE)
    private String topCompanyCode;
    @Query
    private Boolean enabled;

    @Query(type = Query.Type.BETWEEN)
    private List<Timestamp> createTime;
}