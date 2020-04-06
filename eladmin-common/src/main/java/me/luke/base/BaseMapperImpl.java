package me.luke.base;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BaseMapperImpl  {

    public Object toEntityCommon(Object dto) {
        if ( dto == null ) {
            return null;
        }
        BaseEntity baseEntity = new BaseEntity();
        baseEntity.setIsDelete( ((BaseDTO)dto).getIsDelete() );
        baseEntity.setVersion( ((BaseDTO)dto).getVersion() );
        baseEntity.setUpdateTime( ((BaseDTO)dto).getUpdateTime() );
        baseEntity.setCreateTime( ((BaseDTO)dto).getCreateTime() );
        baseEntity.setTopCompanyCode( ((BaseDTO)dto).getTopCompanyCode() );
        return baseEntity;
    }


    public Object toDtoCommon(Object entity) {
        if ( entity == null ) {
            return null;
        }
        BaseDTO baseDTO = new BaseDTO();
        baseDTO.setIsDelete(((BaseEntity)entity).getIsDelete());
        baseDTO.setVersion(((BaseEntity)entity).getVersion());
        baseDTO.setUpdateTime(((BaseEntity)entity).getUpdateTime());
        baseDTO.setCreateTime(((BaseEntity)entity).getCreateTime());
        baseDTO.setTopCompanyCode(((BaseEntity)entity).getTopCompanyCode());
        return baseDTO;
    }


    public List toEntityCommon(List dtoList) {
        if ( dtoList == null ) {
            return null;
        }
        List<Object> lists = new ArrayList<Object>(dtoList.size());
        for(Object objectDTO:dtoList){
            lists.add(toEntityCommon(objectDTO));
        }
        return lists;
    }


    public List toDtoCommon(List entityList) {
        if ( entityList == null ) {
            return null;
        }
        List<Object> list = new ArrayList<Object>( entityList.size() );
        for ( Object objectEntity : entityList ) {
            list.add( toDtoCommon( objectEntity ) );
        }
        return list;
    }

}
