package me.luke.modules.system.service.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.luke.modules.system.domain.SysSkuClassify;
import me.luke.modules.system.service.dto.SysSkuClassifyDto;
import me.luke.modules.system.service.mapper.SysSkuClassifyMapper;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-09T10:50:30+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class SysSkuClassifyMapperImpl implements SysSkuClassifyMapper {

    @Override
    public SysSkuClassify toEntity(SysSkuClassifyDto dto) {
        if ( dto == null ) {
            return null;
        }

        SysSkuClassify sysSkuClassify = new SysSkuClassify();
        sysSkuClassify.setId( dto.getId() );
        sysSkuClassify.setName( dto.getName() );
        sysSkuClassify.setFullName(dto.getFullName());
        sysSkuClassify.setEnabled( dto.getEnabled() );
        sysSkuClassify.setPid( dto.getPid() );
        sysSkuClassify.setRemark( dto.getRemark() );
        sysSkuClassify.setKeywords( dto.getKeywords() );
        sysSkuClassify.setIsDelete( dto.getIsDelete() );
        sysSkuClassify.setVersion( dto.getVersion() );
        sysSkuClassify.setCreateTime( dto.getCreateTime() );
        sysSkuClassify.setUpdateTime( dto.getUpdateTime() );
        sysSkuClassify.setTopCompanyCode( dto.getTopCompanyCode() );


        return sysSkuClassify;
    }

    @Override
    public SysSkuClassifyDto toDto(SysSkuClassify entity) {
        if ( entity == null ) {
            return null;
        }

        SysSkuClassifyDto sysSkuClassifyDto = new SysSkuClassifyDto();
        sysSkuClassifyDto.setId( entity.getId() );
        sysSkuClassifyDto.setName( entity.getName() );
        sysSkuClassifyDto.setFullName(entity.getFullName());
        sysSkuClassifyDto.setEnabled( entity.getEnabled() );
        sysSkuClassifyDto.setPid( entity.getPid() );
        sysSkuClassifyDto.setRemark( entity.getRemark() );
        sysSkuClassifyDto.setKeywords( entity.getKeywords() );
        sysSkuClassifyDto.setIsDelete( entity.getIsDelete() );
        sysSkuClassifyDto.setVersion( entity.getVersion() );
        sysSkuClassifyDto.setCreateTime( entity.getCreateTime() );
        sysSkuClassifyDto.setUpdateTime( entity.getUpdateTime() );
        sysSkuClassifyDto.setTopCompanyCode( entity.getTopCompanyCode() );
        return sysSkuClassifyDto;
    }

    @Override
    public List<SysSkuClassify> toEntity(List<SysSkuClassifyDto> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<SysSkuClassify> list = new ArrayList<SysSkuClassify>( dtoList.size() );
        for ( SysSkuClassifyDto sysSkuClassifyDto : dtoList ) {
            list.add( toEntity( sysSkuClassifyDto ) );
        }

        return list;
    }

    @Override
    public List<SysSkuClassifyDto> toDto(List<SysSkuClassify> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SysSkuClassifyDto> list = new ArrayList<SysSkuClassifyDto>( entityList.size() );
        for ( SysSkuClassify sysSkuClassify : entityList ) {
            list.add( toDto( sysSkuClassify ) );
        }

        return list;
    }
}
