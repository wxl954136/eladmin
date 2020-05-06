package me.luke.modules.po.domain;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Data;
import me.luke.base.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
* @author lukeWang
* @date 2020-05-05
*/
@Entity
@Data
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
}