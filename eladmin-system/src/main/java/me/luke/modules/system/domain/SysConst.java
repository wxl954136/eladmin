package me.luke.modules.system.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
@Entity
@Data
@Table(name="sys_const")
public class SysConst implements Serializable {
    /** 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "type")
    private String type;

    @Column(name = "enabled",nullable = false)
    private Boolean enabled;

    /** 排序  */
    @Column(name="sort" ,nullable = false)
    @NotNull
    private Long sort;


}
