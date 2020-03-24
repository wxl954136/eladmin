package me.zhengjie.modules.system.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
* @author lukeWang
* @date 2020-3-24 16:32:18
*/
@Data
public class BankSmallDto implements Serializable {

    private Long id;

    private String name;
}