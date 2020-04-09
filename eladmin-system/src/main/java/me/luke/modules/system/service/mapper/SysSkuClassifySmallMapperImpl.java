package me.luke.modules.system.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.luke.modules.system.domain.SysSkuClassify;
import me.luke.modules.system.service.dto.SysSkuClassifySmallDto;
import org.springframework.stereotype.Component;


@Component
public class SysSkuClassifySmallMapperImpl implements SysSkuClassifySmallMapper {

    @Override
    public SysSkuClassify toEntity(SysSkuClassifySmallDto dto) {
        if ( dto == null ) {
            return null;
        }

        SysSkuClassify sysSkuClassify = new SysSkuClassify();

        sysSkuClassify.setId( dto.getId() );
        sysSkuClassify.setName( dto.getName() );

        return sysSkuClassify;
    }

    @Override
    public SysSkuClassifySmallDto toDto(SysSkuClassify entity) {
        if ( entity == null ) {
            return null;
        }

        SysSkuClassifySmallDto sysSkuClassifySmallDto = new SysSkuClassifySmallDto();

        sysSkuClassifySmallDto.setId( entity.getId() );
        sysSkuClassifySmallDto.setName( entity.getName() );

        return sysSkuClassifySmallDto;
    }

    @Override
    public List<SysSkuClassify> toEntity(List<SysSkuClassifySmallDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<SysSkuClassify> list = new ArrayList<SysSkuClassify>( dtoList.size() );
        for ( SysSkuClassifySmallDto sysSkuClassifySmallDto : dtoList ) {
            list.add( toEntity( sysSkuClassifySmallDto ) );
        }

        return list;
    }

    @Override
    public List<SysSkuClassifySmallDto> toDto(List<SysSkuClassify> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SysSkuClassifySmallDto> list = new ArrayList<SysSkuClassifySmallDto>( entityList.size() );
        for ( SysSkuClassify sysSkuClassify : entityList ) {
            list.add( toDto( sysSkuClassify ) );
        }

        return list;
    }
}
