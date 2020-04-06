package me.luke.modules.system.service.mapper;

import me.luke.base.BaseMapper;
import me.luke.modules.system.domain.Bank;
import me.luke.modules.system.service.dto.BankDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BankMapper extends BaseMapper<BankDto, Bank> {

}