package com.usercard.user.converters;

import com.usercard.user.dtos.TableScoreDto;
import com.usercard.user.enities.TableScoreEntity;
import org.springframework.beans.BeanUtils;

public class TableScoreConverter {
    public static TableScoreDto toDto(TableScoreEntity entity) {
        TableScoreDto dto = new TableScoreDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static TableScoreEntity toEntity(TableScoreDto dto) {
        TableScoreEntity entity = new TableScoreEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
