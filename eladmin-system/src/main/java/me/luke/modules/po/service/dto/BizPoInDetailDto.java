package me.luke.modules.po.service.dto;

import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import me.luke.modules.system.service.dto.SysSkuSmallDto;

/**
* @author lukeWang
* @date 2020-04-18
*/
@Data
public class BizPoInDetailDto implements Serializable {

    /** 采购单明细表id */
    /** 防止精度丢失 */
    @JsonSerialize(using= ToStringSerializer.class)
    private Long id;

    /** 主表关联 */
    private Long headId;

    private SysSkuSmallDto sysSku;

    /** 数量 */
    private BigDecimal qty;

    /** 采购价 */
    private BigDecimal price;

    /** 税率 */
    private BigDecimal rate;

    /** 备注 */
    private String remark;

    /** 删除标记 */
    private Boolean isDelete;

    /** 版本号 */
    private Integer version;

    /** 修改日期 */
    private Timestamp updateTime;

    /** 创建日期 */
    private Timestamp createTime;

    /** 企业代码 */
    private String topCompanyCode;

    /** 系统注释，不参与程序制作 */
    private String notes;
}