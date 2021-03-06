package me.luke.modules.system.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.Getter;
import lombok.Setter;
import me.luke.base.BaseEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
* @author lukeWang
* @date 2020-04-03
*/
@Entity
@Where(clause=" is_delete= 0  and 1=1 ") //必须是数据库字段，不可以是实体bean field
@Data
@Table(name="sys_store")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class SysStore extends BaseEntity  {
    /** ID */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** uuid相关联 */
    @GeneratedValue(generator = "jpa-uuid")
    @Column(name = "keywords")

    private String keywords;

    /** 仓库名称 */
    @Column(name = "name",nullable = false)
    @NotBlank
    private String name;

    /** 状态 */
    @Column(name = "enabled",nullable = false)
    @NotNull
    private Boolean enabled;


    /** 状态 */
    @Column(name="sort" ,nullable = false)
    @NotNull
    private Long sort;
    /** 关联的信息 */

    @OneToOne
    @JoinColumn(name = "dept_id")
    private Dept dept;

    /** 备注 */
    @Column(name = "remark")
    private String remark;




    public void copy(SysStore source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}