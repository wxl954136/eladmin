package me.luke.modules.system.service.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.luke.modules.system.domain.Bank;
import me.luke.modules.system.service.dto.BankDto;
import me.luke.modules.system.service.mapper.BankMapper;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-01T11:56:50+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class BankMapperImpl implements BankMapper {

    @Override
    public Bank toEntity(BankDto dto) {
        if ( dto == null ) {
            return null;
        }

        Bank bank = new Bank();

        bank.setId( dto.getId() );
        bank.setName( dto.getName() );
        bank.setSort( dto.getSort() );
        bank.setEnabled( dto.getEnabled() );
        bank.setTopCompanyCode( dto.getTopCompanyCode() );
        bank.setCreateTime( dto.getCreateTime() );

        return bank;
    }

    @Override
    public BankDto toDto(Bank entity) {
        if ( entity == null ) {
            return null;
        }

        BankDto bankDto = new BankDto();

        bankDto.setId( entity.getId() );
        bankDto.setSort( entity.getSort() );
        bankDto.setName( entity.getName() );
        bankDto.setEnabled( entity.getEnabled() );
        bankDto.setCreateTime( entity.getCreateTime() );
        bankDto.setTopCompanyCode( entity.getTopCompanyCode() );

        return bankDto;
    }

    @Override
    public List<Bank> toEntity(List<BankDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Bank> list = new ArrayList<Bank>( dtoList.size() );
        for ( BankDto bankDto : dtoList ) {
            list.add( toEntity( bankDto ) );
        }

        return list;
    }

    @Override
    public List<BankDto> toDto(List<Bank> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BankDto> list = new ArrayList<BankDto>( entityList.size() );
        for ( Bank bank : entityList ) {
            list.add( toDto( bank ) );
        }

        return list;
    }
}
