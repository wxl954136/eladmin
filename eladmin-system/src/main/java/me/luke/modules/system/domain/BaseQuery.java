package me.luke.modules.system.domain;


import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

import java.io.Serializable;

/**
* @author lukeWang
* @date 2020-04-03
*/

@Getter
@Setter
//该类为辅助类，如从sku取品牌，颜色 ，主要是为了便于转成json对象供前端获取信息
public class BaseQuery  {



    private Long id;

    private String result ;

    private String content;
    private String value;






}