package me.luke.modules.system.domain.vo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

import java.io.Serializable;

/**
* @author lukeWang
* @date 2020-04-03
*/
@Data
//该类为辅助类，如从sku取品牌，颜色 ，主要是为了便于转成json对象供前端获取信息
public class Assist {

    //顺序 不可以变
    private String result;
    private String value;
    private String content;


    public Assist() {
    }

    public Assist(String value) {
        this.value = value;
    }
    public Assist(String result, String value, String content) {
        this.result = result;
        this.value = value;
        this.content = content;
    }
}

