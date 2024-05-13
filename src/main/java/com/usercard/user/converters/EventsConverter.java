package com.usercard.user.converters;

import com.usercard.user.dtos.EventsDto;
import com.usercard.user.enities.EventsEntity;
import org.springframework.beans.BeanUtils;

public class EventsConverter {
    public static EventsDto toDto(EventsEntity entity) {
        EventsDto dto = new EventsDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static EventsEntity toEntity(EventsDto dto) {
        EventsEntity entity = new EventsEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
