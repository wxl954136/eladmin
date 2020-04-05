package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import me.zhengjie.annotation.Query;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Data
@Where(clause=" is_delete= 0 ") //必须是数据库字段，不可以是实体bean field
public class DeptQueryCriteria{

    @Query(type = Query.Type.IN, propName="id")
    private Set<Long> ids;

    @Query(type = Query.Type.INNER_LIKE)
    private String name;

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