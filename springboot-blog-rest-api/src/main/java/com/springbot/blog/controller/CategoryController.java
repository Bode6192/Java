package com.springbot.blog.controller;

import com.springbot.blog.payload.CategoryDto;
import com.springbot.blog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<CategoryDto> addCategory(@RequestBody CategoryDto categoryDto){

        CategoryDto newCategory = categoryService.addCategory(categoryDto);

        return new ResponseEntity<>(newCategory, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Long categoryId) {

        CategoryDto categoryDto = categoryService.getCategory(categoryId);

        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {

        List<CategoryDto> categoryDtoList = categoryService.getAllCategories();

        return new ResponseEntity<>(categoryDtoList, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategoryById(@RequestBody CategoryDto categoryDto,
                                                          @PathVariable("id") Long categoryId){

        CategoryDto updatedCategory = categoryService.updateCategory(categoryDto, categoryId);

        return ResponseEntity.ok(updatedCategory);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id") Long categoryId) {

        return ResponseEntity.ok(categoryService.deleteCategoryById(categoryId));
    }
}
