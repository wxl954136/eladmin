package me.luke.modules.system.service.mapper;

import me.luke.base.BaseMapper;
import me.luke.modules.system.domain.SysTrader;
import me.luke.modules.system.service.dto.SysTraderDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author lukeWang
* @date 2020-04-16
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysTraderMapper extends BaseMapper<SysTraderDto, SysTrader> {

}