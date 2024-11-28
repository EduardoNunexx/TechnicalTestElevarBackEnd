package com.elevarvendas.technicalTest.model.services.imp;

import com.elevarvendas.technicalTest.dto.categories.CategoryRequestDTO;
import com.elevarvendas.technicalTest.dto.categories.CategoryResponseDTO;
import com.elevarvendas.technicalTest.dto.categories.SubCategoryDto;
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
    @Override
    public SubCategoryDto createSubCategory(Integer parentId, CategoryRequestDTO subcategoryRequestDTO){
        Category parentCategory = categoryRepository.findById(parentId).orElseThrow(()-> new ResourceNotFoundException("Category not found" + parentId));
        Category subCategory =  mapper.convertToObject(subcategoryRequestDTO,Category.class);
        //mudei
        parentCategory.getSubCategories().add(subCategory);

        subCategory.setParentCategory(parentCategory);
        categoryRepository.save(subCategory);

        SubCategoryDto subCategoryDto = mapper.convertToObject(subCategory, SubCategoryDto.class);
        subCategoryDto.setParentCategoryId(subCategory.getId());
        if (subCategoryDto.getSubcategories()!=null) {
            subCategoryDto.setSubcategories(subCategory.getSubCategories().stream().map(x -> mapper.convertToObject(x, SubCategoryDto.class)).collect(Collectors.toList()));
        }
        return subCategoryDto;
    }


    /*private CategoryHierarchDTO categoryHierarch(Integer parentId, CategoryRequestDTO subcategoryRequestDTO) {
        // Verifica se a categoria pai existe
        Category parentCategory = categoryRepository.findById(parentId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found: " + parentId));

        // Converte o DTO da nova subcategoria para a entidade Category
        Category newChildCategory = mapper.convertToObject(subcategoryRequestDTO, Category.class);
        newChildCategory.setParentCategory(parentCategory);

        // Salva a nova subcategoria no banco de dados
        Category savedChildCategory = categoryRepository.save(newChildCategory);

        // Adiciona a nova subcategoria à lista de subcategorias existentes
        List<Category> existingSubCategories = parentCategory.getSubCategories();
        if (existingSubCategories == null) {
            existingSubCategories = new ArrayList<>();
        }
        existingSubCategories.add(savedChildCategory);
        parentCategory.setSubCategories(existingSubCategories);

        // Atualiza a entidade do pai para refletir as mudanças no banco
        categoryRepository.save(parentCategory);

        // Reconstroi a hierarquia de categorias
        List<Category> categoryHierarchy = new ArrayList<>();
        Category currentCategory = parentCategory;

        while (currentCategory != null) {
            categoryHierarchy.add(currentCategory);
            currentCategory = currentCategory.getParentCategory();
        }

        // Reverte a hierarquia para começar da raiz
        Collections.reverse(categoryHierarchy);

        // Constrói o DTO hierárquico
        CategoryHierarchDTO rootCategoryDto = null;
        CategoryHierarchDTO previousDto = null;

        for (Category category : categoryHierarchy) {
            CategoryHierarchDTO currentDto = mapper.convertToObject(category, CategoryHierarchDTO.class);

            if (previousDto != null) {
                currentDto.setSubCategory(previousDto);
            }

            previousDto = currentDto;

            // Define o rootCategoryDto apenas na primeira iteração
            if (rootCategoryDto == null) {
                rootCategoryDto = currentDto;
            }
        }

        // Conecta a nova subcategoria no final da hierarquia
        if (previousDto != null) {
            previousDto.setSubCategory(mapper.convertToObject(savedChildCategory, CategoryHierarchDTO.class));
        }

        return rootCategoryDto;
    }
*/

}
