package com.elevarvendas.technicalTest.model.services;

import com.elevarvendas.technicalTest.dto.categories.CategoryRequestDTO;
import com.elevarvendas.technicalTest.dto.categories.CategoryResponseDTO;
import com.elevarvendas.technicalTest.dto.categories.SubCategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);

    List<CategoryResponseDTO> getAllCategories();

    CategoryResponseDTO getCategoryById(Integer id);

    CategoryResponseDTO updateCategory(Integer id, CategoryRequestDTO categoryRequestDTO);

    void deleteCategory(Integer id);
    SubCategoryDto createSubCategory(Integer id, CategoryRequestDTO categoryRequestDTO);
}

