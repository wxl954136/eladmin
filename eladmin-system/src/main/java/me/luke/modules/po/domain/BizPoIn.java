package me.luke.modules.po.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import lombok.ToString;
import me.luke.base.BaseEntity;
import me.luke.modules.system.domain.SysStore;
import me.luke.modules.system.domain.SysTrader;
import me.luke.modules.utils.SysStatusEnum;
import org.hibernate.annotations.Where;

import javax.persistence.*;


import java.util.List;

/**
* @author lukeWang
* @date 2020-04-17
*/
@Entity
@Data
//关联子对象千万不能toString,要排除，否则报错
@Where(clause=" is_delete= 0  and 1=1 ")

@ToString(exclude={"sysTrader","sysTrader","sysStore","bizPoInDetails"})
@Table(name="biz_po_in")
public class BizPoIn  extends BaseEntity {

    /** 主键 */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "biz_no")
    private String bizNo;

    @Column(name = "biz_type")
    private String bizType = SysStatusEnum.BIZ_NOTE_TYPE_PO_PI.getValue();

    @Column(name = "biz_date")
    private String bizDate;

    @Column(name = "keywords")
    private String keywords;



    @OneToOne
    @JoinColumn(name = "trader_id")
    private SysTrader sysTrader;


    /** 仓库信处n */
    @OneToOne
    @JoinColumn(name = "store_id")
    private SysStore sysStore;

    @OneToMany(mappedBy = "bizPoIn",cascade={CascadeType.PERSIST,CascadeType.REMOVE})
    private List<BizPoInDetail> bizPoInDetails;

    /** 付款方式:1/2/3 */
    @Column(name = "pay_method")
    private Integer payMethod;
    /** 付款方式:1/2/3 */

    @Column(name = "handler")
    private String handler;

    /** 备注 */
    @Column(name = "remark",nullable = false)
    private String remark;


    public void copy(BizPoIn source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}