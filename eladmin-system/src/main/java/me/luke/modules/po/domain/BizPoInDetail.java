package me.luke.modules.po.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.ToString;
import me.luke.base.BaseEntity;
import me.luke.modules.system.domain.DictDetail;
import me.luke.modules.system.domain.SysSku;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;

/**
* @author lukeWang
* @date 2020-04-18
*/
@Entity
@Data
@Where(clause=" is_delete= 0  and 1=1 ")
//关联子对象千万不能toString,要排除，否则报错
@ToString(exclude={"bizPoIn","sysSku"})
@Table(name="biz_po_in_detail")
public class BizPoInDetail extends BaseEntity {

    /** 采购单明细表id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "keywords")
    private String keywords ;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "head_id")
    private BizPoIn bizPoIn;

   // @OneToMany(mappedBy = "bizTradeSerialFlow",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    @Transient  //忽略字段映射，手动指定其指，因为此表是个集合表
    private List<BizTradeSerialFlow> bizTradeSerialFlow;

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

    /** 备注 */
    @Column(name = "remark")
    private String remark;


    public @interface Update {}

    public void copy(BizPoInDetail source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }

    @Override
    public String toString() {

        return "BizPoInDetail [" +
                "id=" + id + ", " +
                "keywords=" + keywords +  ", " +
                "sysSku.id=" + (sysSku == null?"":sysSku.getId())   + ", " +
                "qty=" + Double.parseDouble(qty.toString())   + ", " +
                "price=" + Double.parseDouble(price.toString())   + ", " +
                "rate=" + Double.parseDouble(rate.toString())   + ", " +
                "remark=" + remark  +
                "]";
    }

}