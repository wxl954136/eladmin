package me.luke.modules.po.service.dto;

import lombok.Data;
import me.luke.base.BaseDTO;
import me.luke.modules.system.service.dto.SysStoreSmallDto;
import me.luke.modules.system.service.dto.SysTraderSmallDto;

import java.sql.Timestamp;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
* @author lukeWang
* @date 2020-04-17
*/
@Data
public class BizPoInDto extends BaseDTO {

    /**
     * 主键
     */
    private Long id;
    /**
     * 单据号
     */
    private String bizNo;
    /**
     * 单据日期
     */
    private String bizDate;

    /**
     *  辅助key
     */
    private String keywords;
    /**
     * 往来单位id
     */
    private Long traderId;
    private SysTraderSmallDto sysTrader;
    /**
     * 仓库id
     */
    private Long storeId;
    private SysStoreSmallDto sysStore;

    private List<BizPoInDetailDto> bizPoInDetails;

    /**
     * 付款方式:1/2/3
     */

    private Integer payMethod;
    /**
     * 经手人
     */
    private String handler;


    /**
     * 备注
     */
    private String remark;

}