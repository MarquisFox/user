package com.usercard.user.converters;

import com.usercard.user.dtos.AchievementDto;
import com.usercard.user.enities.AchievementEntity;
import org.springframework.beans.BeanUtils;

public class AchievementConverter {
    public static AchievementDto toDto(AchievementEntity entity) {
        AchievementDto dto = null;
        if (entity != null){
            dto = new AchievementDto();
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }

    public static AchievementEntity toEntity(AchievementDto dto) {
        AchievementEntity entity = null;
        if (dto != null){
            entity = new AchievementEntity();
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }
}
