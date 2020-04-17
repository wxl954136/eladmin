package me.luke.modules.po.service.mapper;

import me.luke.base.BaseMapper;
import me.luke.modules.po.domain.BizPoIn;
import me.luke.modules.po.service.dto.BizPoInDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author lukeWang
* @date 2020-04-17
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BizPoInMapper extends BaseMapper<BizPoInDto, BizPoIn> {

}