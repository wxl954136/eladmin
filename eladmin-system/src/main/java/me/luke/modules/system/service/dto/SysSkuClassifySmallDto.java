package me.luke.modules.system.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
* @author lukeWang
* @date 2020-04-10 16:32:18
*/
@Data
public class SysSkuClassifySmallDto implements Serializable {

    private Long id;
    private String name;
    private String fullName;
}