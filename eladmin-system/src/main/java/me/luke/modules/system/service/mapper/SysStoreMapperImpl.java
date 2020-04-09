package me.luke.modules.system.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.luke.modules.system.domain.Dept;
import me.luke.modules.system.domain.SysStore;
import me.luke.modules.system.service.dto.DeptSmallDto;
import me.luke.modules.system.service.dto.SysStoreDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SysStoreMapperImpl implements SysStoreMapper {

    @Autowired
    private DeptMapper deptMapper;

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
        sysStore.setDept( deptSmallDtoToDept( dto.getDept() ) );
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
        sysStoreDto.setDept( deptToDeptSmallDto( entity.getDept() ) );
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

    protected Dept deptSmallDtoToDept(DeptSmallDto deptSmallDto) {
        if ( deptSmallDto == null ) {
            return null;
        }

        Dept dept = new Dept();

        dept.setId( deptSmallDto.getId() );
        dept.setName( deptSmallDto.getName() );

        return dept;
    }

    protected DeptSmallDto deptToDeptSmallDto(Dept dept) {
        if ( dept == null ) {
            return null;
        }

        DeptSmallDto deptSmallDto = new DeptSmallDto();

        deptSmallDto.setId( dept.getId() );
        deptSmallDto.setName( dept.getName() );

        return deptSmallDto;
    }
}
