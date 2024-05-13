package com.usercard.user.converters;

import com.usercard.user.dtos.Table_scoreDto;
import com.usercard.user.enities.Table_scoreEntity;
import org.springframework.beans.BeanUtils;

public class Table_scoreConverter {
    public static Table_scoreDto toDto(Table_scoreEntity entity) {
        Table_scoreDto dto = new Table_scoreDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static Table_scoreEntity toEntity(Table_scoreDto dto) {
        Table_scoreEntity entity = new Table_scoreEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
