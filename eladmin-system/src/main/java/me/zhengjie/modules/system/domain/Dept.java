package me.zhengjie.modules.system.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Entity
@Where(clause=" is_delete= 0 ") //必须是数据库字段，不可以是实体bean field
@Getter
@Setter
@Table(name="dept")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")

public class Dept implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull(groups = Update.class)
    private Long id;

    @Column(name = "name",nullable = false)
    @NotBlank
    private String name;

    @NotNull
    private Boolean enabled;

    @Column(name = "pid",nullable = false)
    @NotNull
    private Long pid;

    @JsonIgnore
    @ManyToMany(mappedBy = "depts")
    private Set<Role> roles;

    @Column(name = "remark")
    private String remark;

    //不允许有两个id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "keywords")
    private String keywords;

    /** 删除标识 0:未删除  1：删除**/
    @Column(name = "is_delete", columnDefinition = "bit default 0")
    private Boolean isDelete = false;


    @Column(name = "version",nullable = false)
    @NotNull
    private Long version;


    @Column(name = "update_time")
    @UpdateTimestamp
    private Timestamp updateTime;

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;



    //@NotNull
    @Column(name = "top_company_code")
    private String topCompanyCode;


    public @interface Update {}

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Dept dept = (Dept) o;
        return Objects.equals(id, dept.id) &&
                Objects.equals(name, dept.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}