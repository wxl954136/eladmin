package me.luke.service.mapper;

import me.luke.base.BaseMapper;
import me.luke.service.dto.LocalStorageDto;
import me.luke.domain.LocalStorage;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-09-05
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalStorageMapper extends BaseMapper<LocalStorageDto, LocalStorage> {

}