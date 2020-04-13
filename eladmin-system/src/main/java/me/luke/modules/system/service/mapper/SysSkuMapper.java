package me.luke.modules.system.service.mapper;

import me.luke.base.BaseMapper;
import me.luke.modules.system.domain.SysSku;
import me.luke.modules.system.domain.SysSkuClassify;
import me.luke.modules.system.service.dto.SysSkuDto;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author lukeWang
* @date 2020-04-03
*/
@Mapper(componentModel = "spring",uses = {SysSkuClassify.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysSkuMapper extends BaseMapper<SysSkuDto, SysSku> {

}