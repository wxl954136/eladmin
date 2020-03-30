package me.zhengjie.modules.system.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author lukeWang
* @date 2020-03-24
*/
@Getter
@Setter
@NoArgsConstructor
public class BankDto implements Serializable {

    private Long id;

    private Long sort;

    private String name;

    private Boolean enabled;

    private Timestamp createTime;

    private String topCompanyCode;

    public BankDto(String name, Boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }
}