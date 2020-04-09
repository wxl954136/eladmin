package me.luke.modules.system.service.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import me.luke.modules.system.domain.Bank;
import me.luke.modules.system.service.dto.BankSmallDto;
import me.luke.modules.system.service.mapper.BankSmallMapper;
import org.springframework.stereotype.Component;

@Component
public class BankSmallMapperImpl implements BankSmallMapper {

    @Override
    public Bank toEntity(BankSmallDto dto) {
        if ( dto == null ) {
            return null;
        }

        Bank bank = new Bank();

        bank.setId( dto.getId() );
        bank.setName( dto.getName() );

        return bank;
    }

    @Override
    public BankSmallDto toDto(Bank entity) {
        if ( entity == null ) {
            return null;
        }

        BankSmallDto bankSmallDto = new BankSmallDto();

        bankSmallDto.setId( entity.getId() );
        bankSmallDto.setName( entity.getName() );

        return bankSmallDto;
    }

    @Override
    public List<Bank> toEntity(List<BankSmallDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Bank> list = new ArrayList<Bank>( dtoList.size() );
        for ( BankSmallDto bankSmallDto : dtoList ) {
            list.add( toEntity( bankSmallDto ) );
        }

        return list;
    }

    @Override
    public List<BankSmallDto> toDto(List<Bank> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BankSmallDto> list = new ArrayList<BankSmallDto>( entityList.size() );
        for ( Bank bank : entityList ) {
            list.add( toDto( bank ) );
        }

        return list;
    }
}
