package me.luke.modules.po.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import me.luke.modules.system.domain.SysSku;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author lukeWang
* @date 2020-04-18
*/
@Entity
@Data
@Table(name="biz_po_in_detail")
public class BizPoInDetail implements Serializable {

    /** 采购单明细表id */
    @Id
    @Column(name = "id")
    private Long id;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "head_id")
    private BizPoIn bizPoIn;



    @OneToOne
    @JoinColumn(name = "sku_id")
    private SysSku sysSku;


    /** 数量 */
    @Column(name = "qty")
    private BigDecimal qty;

    /** 采购价 */
    @Column(name = "price")
    private BigDecimal price;

    /** 税率 */
    @Column(name = "rate")
    private BigDecimal rate;

    /** 备注 */
    @Column(name = "remark")
    private String remark;

    /** 删除标记 */
    @Column(name = "is_delete")
    private Boolean isDelete;

    /** 版本号 */
    @Column(name = "version")
    private Integer version;

    /** 修改日期 */
    @Column(name = "update_time")
    private Timestamp updateTime;

    /** 创建日期 */
    @Column(name = "create_time")
    private Timestamp createTime;

    /** 企业代码 */
    @Column(name = "top_company_code")
    private String topCompanyCode;

    /** 系统注释，不参与程序制作 */
    @Column(name = "notes")
    private String notes;

    public void copy(BizPoInDetail source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}