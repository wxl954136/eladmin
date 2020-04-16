package me.luke.modules.system.service.dto;

import lombok.Data;
import me.luke.base.BaseDTO;

import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author lukeWang
* @date 2020-04-16
*/
@Data
public class SysTraderDto extends BaseDTO {

    /** 主键 */
    private Long id;
    /** 名称 */
    private String name;

    /** 供应商 */
    private Boolean salerFlag;

    /** 客户商 */
    private Boolean buyerFlag;

    /** 帐期 */
    private Integer period;

    /** 信用额度 */
    private Integer creditAmout;

    /** 联系人 */
    private String contacter;

    /** 电话 */
    private String tel;

    /** 地址 */
    private String address;

    /** 银行名称 */
    private String bankName;

    /** 银行帐户 */
    private String bankAccout;
    /** 状态 */
    private Boolean enabled;
    /** 备注 */
    private String remark;


}