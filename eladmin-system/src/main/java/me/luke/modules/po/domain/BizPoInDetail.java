package me.luke.modules.po.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.ToString;
import me.luke.base.BaseEntity;
import me.luke.modules.system.domain.DictDetail;
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
//关联子对象千万不能toString,要排除，否则报错
@ToString(exclude={"bizPoIn","sysSku"})
@Table(name="biz_po_in_detail")
public class BizPoInDetail extends BaseEntity {

    /** 采购单明细表id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = BizPoInDetail.Update.class)
    @Column(name = "id")
    private Long id;


    @Column(name = "keywords")
    private String keywords ;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "head_id")
    private BizPoIn bizPoIn;

    @Column(name = "biz_type")
    private String bizType = "PI";


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


    public @interface Update {}

    public void copy(BizPoInDetail source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}