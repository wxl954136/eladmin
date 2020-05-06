package me.luke.modules.po.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import me.luke.base.BaseDTO;
import me.luke.modules.system.service.dto.SysSkuSmallDto;

/**
* @author lukeWang
* @date 2020-04-18
*/
@Data
public class BizPoInDetailDto extends BaseDTO {

    /** 采购单明细表id */
    /** 防止精度丢失 */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;
    private String keywords ;
    /** 主表关联 */
    private Long headId;

    private String bizType = "PI";

    private SysSkuSmallDto sysSku;

    private List<BizTradeSerialFlowDto> bizTradeSerialFlow;

    /** 数量 */
    private BigDecimal qty;

    /** 采购价 */
    private BigDecimal price;

    /** 税率 */
    private BigDecimal rate;

    /** 备注 */
    private String remark;


}