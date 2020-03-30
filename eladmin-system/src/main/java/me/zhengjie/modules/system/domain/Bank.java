package me.zhengjie.modules.system.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author lukeWang
* @date 2020-03-24
*/
@Entity
@Getter
@Setter
@Table(name="bank")
public class Bank implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    @Column(name = "name",nullable = false)
    @NotBlank
    private String name;

    @Column(unique = true)
    @NotNull
    private Long sort;

    @Column(name = "enabled",nullable = false)
    @NotNull
    private Boolean enabled;

    @Column(name = "top_company_code",nullable = false)
    @NotBlank
    private String topCompanyCode;

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    public @interface Update {}
}