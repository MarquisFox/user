package com.usercard.user.converters;


import com.usercard.user.dtos.CategoryDto;
import com.usercard.user.enities.CategoryEntity;
import org.springframework.beans.BeanUtils;

public class CategoryConverter {

    public static CategoryDto toDto(CategoryEntity entity) {
        CategoryDto dto = new CategoryDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static CategoryEntity toEntity(CategoryDto dto) {
        CategoryEntity entity = new CategoryEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
