package me.luke.modules.system.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import me.luke.base.BaseEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author lukeWang
* @date 2020-04-16
*/
@Entity
@Where(clause=" is_delete= 0  and 1=1 ") //必须是数据库字段，不可以是实体bean field
@Data
@Table(name="sys_trader")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SysTrader extends BaseEntity {

    /** 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** 名称 */
    @Column(name = "name",nullable = false)
    @NotBlank
    private String name;


    @Column(name = "keywords")
    private String keywords;


    /** 供应商 */
    @Column(name = "saler_flag",nullable = false)
    @NotNull
    private Boolean salerFlag;

    /** 客户商 */
    @Column(name = "buyer_flag",nullable = false)
    @NotNull
    private Boolean buyerFlag;

    /** 帐期 */
    @Column(name = "period",nullable = false)
    @NotNull
    private Integer period;

    /** 信用额度 */
    @Column(name = "credit_amout",nullable = false)
    @NotNull
    private Integer creditAmout;

    /** 联系人 */
    @Column(name = "contacter")
    private String contacter;

    /** 电话 */
    @Column(name = "tel")
    private String tel;

    /** 地址 */
    @Column(name = "address")
    private String address;

    /** 银行名称 */
    @Column(name = "bank_name")
    private String bankName;

    /** 银行帐户 */
    @Column(name = "bank_accout")
    private String bankAccout;

    /** 状态 */
    @Column(name = "enabled",nullable = false)
    @NotNull
    private Boolean enabled;

    /** 备注 */
    @Column(name = "remark")
    private String remark;


    public void copy(SysTrader source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}