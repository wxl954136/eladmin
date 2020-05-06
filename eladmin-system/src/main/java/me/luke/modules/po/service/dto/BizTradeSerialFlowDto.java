package me.luke.modules.po.service.dto;

import lombok.Data;
import me.luke.base.BaseDTO;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
* @author lukeWang
* @date 2020-05-05
*/
@Data
public class BizTradeSerialFlowDto extends BaseDTO {

    /** id */
    private Long id;

    /** uuid */
    private String keywords;

    /** 头表keywords*/
    private String bizHeadKeywords;

    /** 业务关联表商品明细头表keywords */
    private String bizDetailKeywords;



    /** 业务单据日期 */
    private String bizDate;

    /** 单据类型 */
    private String bizType;

    /** 往来单位id */
    private Long traderId;

    /** 仓库id */
    private Long storeId;

    /** 商品id */
    private Long skuId;

    /** 串号01 */
    private String serial01;

    /** 串号02 */
    private String serial02;

    /** 串号03 */
    private String serial03;

    /** 数量 */
    private BigDecimal qty;

    /** 单价 */
    private BigDecimal price;

    /** 税率 */
    private BigDecimal rate;

}