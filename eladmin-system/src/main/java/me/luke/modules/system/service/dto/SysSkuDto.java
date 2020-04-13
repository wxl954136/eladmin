package me.luke.modules.system.service.dto;

import lombok.Data;
import me.luke.base.BaseDTO;

/**
* @author lukeWang
* @date 2020-04-03
*/
@Data
public class SysSkuDto extends  BaseDTO   {

    /** ID */
    private Long id;

    private String keywords;

    private String code;

    private String mnemonicCode;

    private String pinyin;

    private String name;

    private String  brand;

    private String color;

    private String fullName;

    private SysSkuClassifySmallDto sysSkuClassify;

    private Long classifyId;

    private Integer stockAge;

    private Boolean costFlag;

    private String serialInfo;

    private String basicId;

    private Boolean virFlag;

    private Boolean enabled;

    private Long sort;

    private String remark;
}