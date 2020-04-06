package me.zhengjie.modules.system.service.dto;

import lombok.Data;
import me.zhengjie.base.BaseDTO;

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

    /** 备注 */
    private String remark;

/*

    private Boolean isDelete;
    private Integer version;
    private Timestamp updateTime;
    private Timestamp createTime;
    private String topCompanyCode;
*/
 // 系统注释，不参与程序制作
//    private String notes;
}