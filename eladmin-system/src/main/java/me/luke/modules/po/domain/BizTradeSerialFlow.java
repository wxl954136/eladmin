package me.luke.modules.po.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;
import me.luke.base.BaseEntity;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

/**
* @author lukeWang
* @date 2020-05-05
*/
@Entity
@Data
@Where(clause=" is_delete= 0  and 1=1 ")
@Table(name="biz_trade_serial_flow")
public class BizTradeSerialFlow extends BaseEntity {

    /** id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** uuid */
    @Column(name = "keywords")
    private String keywords;

    /** 头表keywords*/
    @Column(name = "biz_head_keywords")
    private String bizHeadKeywords;

    /** 业务关联表商品明细id */
    @Column(name = "biz_detail_keywords")
    private String bizDetailKeywords;

    /** 业务单据日期 */
    @Column(name = "biz_date")
    private String bizDate;

    /** 单据类型 */
    @Column(name = "biz_type")
    private String bizType;

    /** 往来单位id */
    @Column(name = "trader_id")
    private Long traderId;

    /** 仓库id */
    @Column(name = "store_id")
    private Long storeId;

    /** 商品id */
    @Column(name = "sku_id")
    private Long skuId;

    /** 串号01 */
    @Column(name = "serial01")
    private String serial01;

    /** 串号02 */
    @Column(name = "serial02")
    private String serial02;

    /** 串号03 */
    @Column(name = "serial03")
    private String serial03;

    /** 数量 */
    @Column(name = "qty")
    private BigDecimal qty;

    /** 单价 */
    @Column(name = "price")
    private BigDecimal price;

    /** 税率 */
    @Column(name = "rate")
    private BigDecimal rate;


    public @interface Update {}

    public void copy(BizTradeSerialFlow source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }



    @Override
    public String toString() {

        return "BizTradeSerialFlow [" +
                "id=" + id + ", " +
                "keywords=" + keywords +  ", " +
                "bizHeadKeywords=" + bizHeadKeywords +  ", " +
                "bizDetailKeywords=" + bizDetailKeywords +  ", " +
                "bizDetailKeywords=" + bizDetailKeywords +  ", " +
                "storeId=" + storeId +  ", " +
                "skuId=" + skuId +  ", " +
                "serial01=" + serial01 +  ", " +
                "serial02=" + serial02 +  ", " +
                "serial03=" + serial03 +  ", " +
                "qty=" + Double.parseDouble(qty.toString())   + ", " +
                "price=" + Double.parseDouble(price.toString())  +
                "]";
    }
}