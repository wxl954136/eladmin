package me.zhengjie.base;

import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;
import java.lang.reflect.Field;

/**
 * @author luke wang
 * @Date 2020年3月23日10:00:03
 * @Remark 赤壁悠易科技有限公司
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {

    /** 删除标识 **/
    @Column(name = "is_delete", columnDefinition = "bit default 0")

    private Boolean isDelete = false;

    @Column(name = "create_time")
    @CreationTimestamp
    private Timestamp createTime;

    @Column(name = "update_time")
    @UpdateTimestamp
    private Timestamp updateTime;

    public @interface Update {}

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this);
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field f : fields) {
                f.setAccessible(true);
                builder.append(f.getName(), f.get(this)).append("\n");
            }
        } catch (Exception e) {
            builder.append("toString builder encounter an error");
        }
        return builder.toString();
    }
}
