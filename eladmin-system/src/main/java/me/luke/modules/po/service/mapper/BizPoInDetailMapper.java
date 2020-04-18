package me.luke.modules.po.service.mapper;

import me.luke.base.BaseMapper;
import me.luke.modules.po.domain.BizPoInDetail;
import me.luke.modules.po.service.dto.BizPoInDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author lukeWang
* @date 2020-04-18
*/
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BizPoInDetailMapper extends BaseMapper<BizPoInDetailDto, BizPoInDetail> {

}