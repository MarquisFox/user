package com.usercard.user.services;


import com.usercard.user.converters.CategoryConverter;
import com.usercard.user.dtos.CategoryDto;
import com.usercard.user.repo.CategoryRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class CategoryService {
    private final CategoryRepo categoryRepo;
    private final Random random = new Random();

    public List<CategoryDto> showAllCategory() {
        return categoryRepo.findAll().stream().map(CategoryConverter::toDto).collect(Collectors.toList());
    }

    public CategoryDto showCategoryDto(long id) {
        return CategoryConverter.toDto(categoryRepo.findById(id).get());
    }

    public boolean addCategoryList(List<CategoryDto> dtoList) {
        categoryRepo.saveAll(dtoList.stream().map(CategoryConverter::toEntity).collect(Collectors.toList()));
        return true;
    }

    @Transactional
    public boolean updateCategory(CategoryDto dto) {
        if (categoryRepo.existsById(dto.getId())) {
            categoryRepo.save(CategoryConverter.toEntity(dto));
            return true;
        }
        return false;
    }

    public boolean deleteCategoryById(long id) {
        categoryRepo.deleteById(id);
        return true;
    }
}
