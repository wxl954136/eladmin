package me.luke.modules.system.service.mapper;

import me.luke.base.BaseMapper;
import me.luke.modules.system.domain.Dept;
import me.luke.modules.system.domain.SysSkuClassify;
import me.luke.modules.system.service.dto.DeptSmallDto;
import me.luke.modules.system.service.dto.SysSkuClassifySmallDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SysSkuClassifySmallMapper extends BaseMapper<SysSkuClassifySmallDto, SysSkuClassify> {

}