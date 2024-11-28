package com.elevarvendas.technicalTest.controller;


import com.elevarvendas.technicalTest.dto.categories.CategoryRequestDTO;
import com.elevarvendas.technicalTest.dto.categories.CategoryResponseDTO;
import com.elevarvendas.technicalTest.dto.categories.SubCategoryDto;
import com.elevarvendas.technicalTest.model.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody @Valid CategoryRequestDTO categoryRequestDTO) {
        CategoryResponseDTO createdCategory = categoryService.createCategory(categoryRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategory);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getCategoryById(@PathVariable Integer id) {
        CategoryResponseDTO category = categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        List<CategoryResponseDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Integer id, @RequestBody @Valid CategoryRequestDTO categoryRequestDTO) {
        CategoryResponseDTO updatedCategory = categoryService.updateCategory(id, categoryRequestDTO);
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{parentId}/subcategories")
    public ResponseEntity<SubCategoryDto> createSubCategory(
            @PathVariable Integer parentId,
            @RequestBody @Valid CategoryRequestDTO subCategoryRequestDTO) {
        SubCategoryDto updatedCategory = categoryService.createSubCategory(parentId, subCategoryRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedCategory);
    }
}
