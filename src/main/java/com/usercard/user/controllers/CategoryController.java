package com.usercard.user.controllers;

import com.usercard.user.dtos.AchievementDto;
import com.usercard.user.dtos.CategoryDto;
import com.usercard.user.services.AchievementService;
import com.usercard.user.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/get-category")
    public List<CategoryDto> getCategory() {
        return categoryService.showAllCategory();
    }

    @PostMapping("/get-category-by-id")
    public CategoryDto showCategoryDto(@RequestParam long id) {
        return categoryService.showCategoryDto(id);
    }

    @PostMapping("/save-all-category")
    public boolean saveCategory(@RequestBody List<CategoryDto> dto) {
        return categoryService.addCategoryList(dto);
    }

    @PutMapping("/update-category")
    public boolean updateCategory(@RequestBody CategoryDto dto) {
        return categoryService.updateCategory(dto);
    }

    @DeleteMapping("/delete-category-by-id")
    public boolean deleteCategoryById(@RequestParam long id) {
        return categoryService.deleteCategoryById(id);
    }
}
