package me.luke.modules.system.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Getter;
import lombok.Setter;
import me.luke.base.BaseEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
* @author lukeWang
* @date 2020-04-03
*/
@Entity
@Where(clause=" is_delete= 0  and 1=1 ") //必须是数据库字段，不可以是实体bean field
@Getter
@Setter
@Table(name="sys_sku")

@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SysSku extends BaseEntity  {
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** uuid相关联 */
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "keywords")

    private String keywords;

    /** SKU代码 */
    @Column(name = "code")
    private String code;

    /** SKU助记码 */
    @Column(name = "mnemonic_code")
    private String mnemonicCode;

    /** pinyin码 */
    @Column(name = "pinyin")
    private String pinyin;

    /** sku名称 */
    @Column(name = "name",nullable = false)
    @NotBlank
    private String name;

    /** 品牌  */
    @Column(name = "brand")
    private String  brand;


    /** 颜色 */
    @Column(name = "color")
    private String color;

    /** 颜色 */
    @Column(name = "full_name")
    private String fullName;

    @OneToOne
    @JoinColumn(name = "classify_id")
    private SysSkuClassify sysSkuClassify;

    /** 库龄 */
    @Column(name = "stock_age")
    private Integer stockAge;

    /** 成本讲价方式:0：加权平均  1:个别计价 */
    @Column(name="cost_flag" ,nullable = false)
    @NotNull
    private Boolean costFlag;


    /** 串号规则 */
    @Column(name = "serial_info")
    private String serialInfo;


    /** 基准库的商品关联id */
    @Column(name = "basic_id")
    private String basicId;


    /** 是否虚拟商品   0:非虚拟商品  1:虚拟商品 */
    @Column(name="vir_flag" ,nullable = false)
    @NotNull
    private Boolean virFlag;

    /** 状态 */
    @Column(name = "enabled",nullable = false)
    @NotNull
    private Boolean enabled;

    /** 排序  */
    @Column(name="sort" ,nullable = false)
    @NotNull
    private Long sort;


    /** 备注 */
    @Column(name = "remark")
    private String remark;


    public void copy(SysSku source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}