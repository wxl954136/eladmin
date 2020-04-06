package me.zhengjie.modules.system.service.mapper;

import me.zhengjie.base.BaseMapper;
import me.zhengjie.modules.system.domain.SysStore;
import me.zhengjie.modules.system.service.dto.SysStoreDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author lukeWang
* @date 2020-04-03
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysStoreMapper extends BaseMapper<SysStoreDto, SysStore> {

}