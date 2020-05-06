package me.luke.modules.po.service.dto;

import lombok.Data;
import me.luke.annotation.Query;

import java.util.Set;

/**
* @author lukeWang
* @date 2020-05-05
*/
@Data
public class BizTradeSerialFlowQueryCriteria{
    @Query(type = Query.Type.IN, propName="id")
    private Set<Long> ids;

    @Query(type = Query.Type.IN, propName="biz_detail_keywords")
    private Set<Long> bizDetailKeywords;
}