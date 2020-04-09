package me.luke.modules.system.service.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.luke.modules.system.domain.SysStore;
import me.luke.modules.system.domain.SysStore;
import me.luke.modules.system.service.dto.SysStoreSmallDto;
import me.luke.modules.system.service.dto.SysStoreDto;
import me.luke.modules.system.service.mapper.SysStoreMapper;
import me.luke.modules.system.service.mapper.SysStoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SysStoreMapperImpl implements SysStoreMapper {

    @Autowired
    private SysStoreMapper sysStoreMapper;

    @Override
    public SysStore toEntity(SysStoreDto dto) {
        if ( dto == null ) {
            return null;
        }

        SysStore sysStore = new SysStore();


        sysStore.setId( dto.getId() );
        sysStore.setKeywords( dto.getKeywords() );
        sysStore.setName( dto.getName() );
        sysStore.setEnabled( dto.getEnabled() );
        sysStore.setSort( dto.getSort() );
      //  sysStore.setSysStore( sysStoreSmallDtoToSysStore( dto.getSysStore() ) );
        sysStore.setRemark( dto.getRemark() );
        sysStore.setIsDelete( dto.getIsDelete() );
        sysStore.setVersion( dto.getVersion() );
        sysStore.setCreateTime( dto.getCreateTime() );
        sysStore.setUpdateTime( dto.getUpdateTime() );
        sysStore.setTopCompanyCode( dto.getTopCompanyCode() );

        return sysStore;
    }

    @Override
    public SysStoreDto toDto(SysStore entity) {
        if ( entity == null ) {
            return null;
        }
        SysStoreDto sysStoreDto = new SysStoreDto();
        sysStoreDto.setIsDelete( entity.getIsDelete() );
        sysStoreDto.setVersion( entity.getVersion() );
        sysStoreDto.setCreateTime( entity.getCreateTime() );
        sysStoreDto.setUpdateTime( entity.getUpdateTime() );
        sysStoreDto.setTopCompanyCode( entity.getTopCompanyCode() );
        sysStoreDto.setId( entity.getId() );
        sysStoreDto.setKeywords( entity.getKeywords() );
        sysStoreDto.setName( entity.getName() );
        sysStoreDto.setSort( entity.getSort() );
        sysStoreDto.setEnabled( entity.getEnabled() );
       // sysStoreDto.setSysStore( sysStoreToSysStoreSmallDto( entity.getSysStore() ) );
        sysStoreDto.setRemark( entity.getRemark() );

        return sysStoreDto;
    }

    @Override
    public List<SysStore> toEntity(List<SysStoreDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<SysStore> list = new ArrayList<SysStore>( dtoList.size() );
        for ( SysStoreDto sysStoreDto : dtoList ) {
            list.add( toEntity( sysStoreDto ) );
        }

        return list;
    }

    @Override
    public List<SysStoreDto> toDto(List<SysStore> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SysStoreDto> list = new ArrayList<SysStoreDto>( entityList.size() );
        for ( SysStore sysStore : entityList ) {
            list.add( toDto( sysStore ) );
        }

        return list;
    }

    protected SysStore sysStoreSmallDtoToSysStore(SysStoreSmallDto sysStoreSmallDto) {
        if ( sysStoreSmallDto == null ) {
            return null;
        }

        SysStore sysStore = new SysStore();

        sysStore.setId( sysStoreSmallDto.getId() );
        sysStore.setName( sysStoreSmallDto.getName() );

        return sysStore;
    }

    protected SysStoreSmallDto sysStoreToSysStoreSmallDto(SysStore sysStore) {
        if ( sysStore == null ) {
            return null;
        }

        SysStoreSmallDto sysStoreSmallDto = new SysStoreSmallDto();

        sysStoreSmallDto.setId( sysStore.getId() );
        sysStoreSmallDto.setName( sysStore.getName() );

        return sysStoreSmallDto;
    }
}
