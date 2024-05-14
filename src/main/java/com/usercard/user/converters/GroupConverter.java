package com.usercard.user.converters;

import com.usercard.user.dtos.CategoryDto;
import com.usercard.user.dtos.GroupDto;
import com.usercard.user.enities.CategoryEntity;
import com.usercard.user.enities.GroupEntity;
import org.springframework.beans.BeanUtils;

public class GroupConverter {

    public static GroupDto toDto(GroupEntity entity) {
        GroupDto dto = null;
        if(entity != null){
            dto = new GroupDto();
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }

    public static GroupEntity toEntity(GroupDto dto) {
        GroupEntity entity = null;
        if(dto != null){
            entity = new GroupEntity();
            BeanUtils.copyProperties(dto, entity);
        }

        return entity;
    }
}
