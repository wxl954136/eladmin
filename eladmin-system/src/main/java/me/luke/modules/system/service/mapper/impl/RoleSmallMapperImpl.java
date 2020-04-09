package me.luke.modules.system.service.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.luke.modules.system.domain.Role;
import me.luke.modules.system.service.dto.RoleSmallDto;
import me.luke.modules.system.service.mapper.RoleSmallMapper;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-01T11:56:50+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class RoleSmallMapperImpl implements RoleSmallMapper {

    @Override
    public Role toEntity(RoleSmallDto dto) {
        if ( dto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( dto.getId() );
        role.setName( dto.getName() );
        role.setDataScope( dto.getDataScope() );
        role.setLevel( dto.getLevel() );

        return role;
    }

    @Override
    public RoleSmallDto toDto(Role entity) {
        if ( entity == null ) {
            return null;
        }

        RoleSmallDto roleSmallDto = new RoleSmallDto();

        roleSmallDto.setId( entity.getId() );
        roleSmallDto.setName( entity.getName() );
        roleSmallDto.setLevel( entity.getLevel() );
        roleSmallDto.setDataScope( entity.getDataScope() );

        return roleSmallDto;
    }

    @Override
    public List<Role> toEntity(List<RoleSmallDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>( dtoList.size() );
        for ( RoleSmallDto roleSmallDto : dtoList ) {
            list.add( toEntity( roleSmallDto ) );
        }

        return list;
    }

    @Override
    public List<RoleSmallDto> toDto(List<Role> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RoleSmallDto> list = new ArrayList<RoleSmallDto>( entityList.size() );
        for ( Role role : entityList ) {
            list.add( toDto( role ) );
        }

        return list;
    }
}
