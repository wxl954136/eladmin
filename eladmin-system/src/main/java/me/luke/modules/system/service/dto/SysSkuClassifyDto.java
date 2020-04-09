package me.luke.modules.system.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import me.luke.base.BaseDTO;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Data
public class SysSkuClassifyDto extends BaseDTO {

    private Long id;

    private String name;
    private String fullName;
    @NotNull
    private Boolean enabled;

    private Long pid;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SysSkuClassifyDto> children;

    private String remark;

    private String keywords;



    public String getLabel() {
        return name;
    }
}