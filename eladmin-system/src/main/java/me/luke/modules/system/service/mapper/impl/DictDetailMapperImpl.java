package me.luke.modules.system.service.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import me.luke.modules.system.domain.DictDetail;
import me.luke.modules.system.service.dto.DictDetailDto;
import me.luke.modules.system.service.mapper.DictDetailMapper;
import me.luke.modules.system.service.mapper.DictSmallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DictDetailMapperImpl implements DictDetailMapper {

    @Autowired
    private DictSmallMapper dictSmallMapper;

    @Override
    public DictDetail toEntity(DictDetailDto dto) {
        if ( dto == null ) {
            return null;
        }

        DictDetail dictDetail = new DictDetail();

        dictDetail.setId( dto.getId() );
        dictDetail.setLabel( dto.getLabel() );
        dictDetail.setValue( dto.getValue() );
        dictDetail.setSort( dto.getSort() );
        dictDetail.setDict( dictSmallMapper.toEntity( dto.getDict() ) );
        dictDetail.setCreateTime( dto.getCreateTime() );

        return dictDetail;
    }

    @Override
    public DictDetailDto toDto(DictDetail entity) {
        if ( entity == null ) {
            return null;
        }

        DictDetailDto dictDetailDto = new DictDetailDto();

        dictDetailDto.setId( entity.getId() );
        dictDetailDto.setLabel( entity.getLabel() );
        dictDetailDto.setValue( entity.getValue() );
        dictDetailDto.setSort( entity.getSort() );
        dictDetailDto.setDict( dictSmallMapper.toDto( entity.getDict() ) );
        dictDetailDto.setCreateTime( entity.getCreateTime() );

        return dictDetailDto;
    }

    @Override
    public List<DictDetail> toEntity(List<DictDetailDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DictDetail> list = new ArrayList<DictDetail>( dtoList.size() );
        for ( DictDetailDto dictDetailDto : dtoList ) {
            list.add( toEntity( dictDetailDto ) );
        }

        return list;
    }

    @Override
    public List<DictDetailDto> toDto(List<DictDetail> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DictDetailDto> list = new ArrayList<DictDetailDto>( entityList.size() );
        for ( DictDetail dictDetail : entityList ) {
            list.add( toDto( dictDetail ) );
        }

        return list;
    }
}
