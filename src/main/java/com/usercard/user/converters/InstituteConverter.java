package com.usercard.user.converters;

import com.usercard.user.dtos.InstituteDto;
import com.usercard.user.enities.InstituteEntity;
import org.springframework.beans.BeanUtils;

public class InstituteConverter {
    public static InstituteDto toDto(InstituteEntity entity) {
        InstituteDto dto = new InstituteDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static InstituteEntity toEntity(InstituteDto dto) {
        InstituteEntity entity = new InstituteEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
