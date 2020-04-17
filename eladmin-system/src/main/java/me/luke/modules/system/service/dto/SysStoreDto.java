package me.luke.modules.system.service.dto;

import lombok.Data;
import me.luke.base.BaseDTO;

import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author lukeWang
* @date 2020-04-03
*/
@Data
public class SysStoreDto extends  BaseDTO   {

    /** ID */
    private Long id;

    /** uuid相关联 */
    private String keywords;

    /** 仓库名称 */
    private String name;

    /** 排序 */
    private Long sort;

    /** 状态 */
    private Boolean enabled;

    private DeptSmallDto dept;

    private Long deptId;
    /** 备注 */
    private String remark;

}