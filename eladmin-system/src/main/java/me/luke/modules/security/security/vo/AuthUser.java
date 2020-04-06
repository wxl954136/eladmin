package me.luke.modules.security.security.vo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author Zheng Jie
 * @date 2018-11-30
 */
@Getter
@Setter
public class AuthUser {
    @NotBlank
    private String topcompanycode;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String code;

    private String uuid = "";

    @Override
    public String toString() {
        return "{topcompanycode=" + topcompanycode + ",username=" + username  + ", password= ******}";
    }
}
