package me.luke.modules.po.service.mapper;

import me.luke.base.BaseMapper;
import me.luke.modules.po.domain.BizTradeSerialFlow;
import me.luke.modules.po.service.dto.BizTradeSerialFlowDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author lukeWang
* @date 2020-05-05
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BizTradeSerialFlowMapper extends BaseMapper<BizTradeSerialFlowDto, BizTradeSerialFlow> {

}