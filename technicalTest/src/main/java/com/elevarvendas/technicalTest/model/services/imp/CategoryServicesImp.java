package com.elevarvendas.technicalTest.model.services.imp;

import com.elevarvendas.technicalTest.dto.categories.CategoryRequestDTO;
import com.elevarvendas.technicalTest.dto.categories.CategoryResponseDTO;
import com.elevarvendas.technicalTest.exceptions.ResourceNotFoundException;
import com.elevarvendas.technicalTest.mapper.Mapper;
import com.elevarvendas.technicalTest.model.entities.Category;
import com.elevarvendas.technicalTest.model.repository.CategoryRepository;
import com.elevarvendas.technicalTest.model.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServicesImp implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private Mapper mapper;

    @Transactional
    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = mapper.convertToObject(categoryRequestDTO, Category.class);
        //todo verificar isso aqui
        // Subcategorias não podem ser criadas diretamente no request, então são ignoradas
        category.setSubCategories(null);

        Category savedCategory = categoryRepository.save(category);
        return mapper.convertToObject(savedCategory, CategoryResponseDTO.class);
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(category -> mapper.convertToObject(category, CategoryResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDTO getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found:" + id));
        return mapper.convertToObject(category, CategoryResponseDTO.class);
    }

    @Transactional
    @Override
    public CategoryResponseDTO updateCategory(Integer id, CategoryRequestDTO categoryRequestDTO) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found " + id));

        mapper.mapToObject(categoryRequestDTO, existingCategory);
        //todo verify this
        // Subcategorias não são atualizadas diretamente neste método
        existingCategory.setSubCategories(existingCategory.getSubCategories());

        Category updatedCategory = categoryRepository.save(existingCategory);
        return mapper.convertToObject(updatedCategory, CategoryResponseDTO.class);
    }

    @Transactional
    @Override
    public void deleteCategory(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found" + id));
        categoryRepository.delete(category);
    }
}
