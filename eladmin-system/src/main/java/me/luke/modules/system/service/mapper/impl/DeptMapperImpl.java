package me.luke.modules.system.service.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import me.luke.modules.system.domain.Dept;
import me.luke.modules.system.service.dto.DeptDto;
import me.luke.modules.system.service.mapper.DeptMapper;
import org.springframework.stereotype.Component;


@Component
public class DeptMapperImpl implements DeptMapper {

    @Override
    public Dept toEntity(DeptDto dto) {
        /*
        if ( dto == null ) {
            return null;
        }
        Dept dept = new Dept();
        dept.setId( dto.getId() );
        dept.setName( dto.getName() );
        dept.setEnabled( dto.getEnabled() );
        dept.setPid( dto.getPid() );
        dept.setRemark(dto.getRemark());
        dept.setIsDelete(dto.getIsDelete());
        dept.setUpdateTime( dto.getUpdateTime() );
        dept.setCreateTime( dto.getCreateTime() );
        dept.setVersion( dto.getVersion());  //每次保存时行记录版本号须自增
        dept.setKeywords( dto.getKeywords());
        dept.setTopCompanyCode( dto.getTopCompanyCode() );
        return dept;*/
        return null;
    }

    @Override
    public DeptDto toDto(Dept entity) {
        if ( entity == null ) {
            return null;
        }

        DeptDto deptDto = new DeptDto();

        deptDto.setId( entity.getId() );
        deptDto.setName( entity.getName() );
        deptDto.setEnabled( entity.getEnabled() );
        deptDto.setPid( entity.getPid() );
        deptDto.setRemark(entity.getRemark());
        deptDto.setIsDelete(entity.getIsDelete());
        deptDto.setUpdateTime( entity.getUpdateTime() );
        deptDto.setCreateTime( entity.getCreateTime() );
        deptDto.setKeywords( entity.getKeywords() );
        deptDto.setVersion( entity.getVersion());
        deptDto.setTopCompanyCode( entity.getTopCompanyCode() );

        return deptDto;
    }

    @Override
    public List<Dept> toEntity(List<DeptDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Dept> list = new ArrayList<Dept>( dtoList.size() );
        for ( DeptDto deptDto : dtoList ) {
            list.add( toEntity( deptDto ) );
        }

        return list;
    }

    @Override
    public List<DeptDto> toDto(List<Dept> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DeptDto> list = new ArrayList<DeptDto>( entityList.size() );
        for ( Dept dept : entityList ) {
            list.add( toDto( dept ) );
        }

        return list;
    }
}
