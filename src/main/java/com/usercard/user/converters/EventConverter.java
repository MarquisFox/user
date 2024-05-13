package com.usercard.user.converters;

import com.usercard.user.dtos.EventDto;
import com.usercard.user.enities.EventEntity;
import org.springframework.beans.BeanUtils;

public class EventConverter {
    public static EventDto toDto(EventEntity entity) {
        EventDto dto = new EventDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static EventEntity toEntity(EventDto dto) {
        EventEntity entity = new EventEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
