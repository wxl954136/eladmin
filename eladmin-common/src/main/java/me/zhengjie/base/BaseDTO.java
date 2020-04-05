package me.zhengjie.base;

import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author luke wang
 * @Date 2020年3月23日10:00:03
 */
@Getter
@Setter
public class BaseDTO  implements Serializable {

    private Boolean isDelete;
    private Integer version;
    private Timestamp createTime;
    private Timestamp updateTime;
    private String topCompanyCode;

    @Override
    public String toString() {
        return "BaseDTO{" +
                "isDelete=" + isDelete +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", topCompanyCode=" + topCompanyCode +
                '}';
    }
}
