package me.luke.modules.po.service.dto;

import lombok.Data;
import java.util.List;
import me.luke.annotation.Query;

/**
* @author lukeWang
* @date 2020-04-18
*/
@Data
public class BizPoInDetailQueryCriteria{

    /** 模糊 */
    @Query(type = Query.Type.INNER_LIKE)
    private Long skuId;
}