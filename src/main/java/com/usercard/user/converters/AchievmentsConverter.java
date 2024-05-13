package com.usercard.user.converters;

import com.usercard.user.dtos.AchievmentsDto;
import com.usercard.user.enities.AchievmentsEntity;
import org.springframework.beans.BeanUtils;

public class AchievmentsConverter {
    public static AchievmentsDto toDto(AchievmentsEntity entity) {
        AchievmentsDto dto = new AchievmentsDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static AchievmentsEntity toEntity(AchievmentsDto dto) {
        AchievmentsEntity entity = new AchievmentsEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
