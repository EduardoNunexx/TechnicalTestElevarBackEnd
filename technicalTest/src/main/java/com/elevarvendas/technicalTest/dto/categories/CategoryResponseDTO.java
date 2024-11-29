package com.elevarvendas.technicalTest.dto.categories;

import com.elevarvendas.technicalTest.model.entities.Category;

import java.io.Serializable;
import java.util.List;

public class CategoryResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String description;
    private Integer parentCategoryId;
    private List<CategoryResponseDTO> subcategories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CategoryResponseDTO> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<CategoryResponseDTO> subcategories) {
        this.subcategories = subcategories;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }
}
