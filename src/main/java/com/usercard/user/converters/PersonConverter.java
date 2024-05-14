package com.usercard.user.converters;

import com.usercard.user.dtos.PersonDto;
import com.usercard.user.enities.PersonEntity;
import org.springframework.beans.BeanUtils;

public class PersonConverter {
    public static PersonDto toDto(PersonEntity entity) {
        PersonDto dto = null;
        if(entity != null) {
            dto = new PersonDto();
            BeanUtils.copyProperties(entity, dto);
        }
        return dto;
    }

    public static PersonEntity toEntity(PersonDto dto) {
        PersonEntity entity = null;
        if(dto != null) {
            entity = new PersonEntity();
            BeanUtils.copyProperties(dto, entity);
        }
        return entity;
    }
}
