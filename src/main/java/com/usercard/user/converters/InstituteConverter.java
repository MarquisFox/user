package com.usercard.user.converters;

import com.usercard.user.dtos.InstituteDto;
import com.usercard.user.enities.InstituteEntity;
import org.springframework.beans.BeanUtils;

public class InstituteConverter {
    public static InstituteDto toDto(InstituteEntity entity) {
        InstituteDto dto = null;
        if(entity != null){
            dto = new InstituteDto();
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }

    public static InstituteEntity toEntity(InstituteDto dto) {
        InstituteEntity entity = null;
        if(dto != null){
            entity = new InstituteEntity();
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }
}
