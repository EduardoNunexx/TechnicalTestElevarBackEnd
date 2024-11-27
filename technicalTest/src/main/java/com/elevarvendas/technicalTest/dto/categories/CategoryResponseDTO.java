package com.elevarvendas.technicalTest.dto.categories;

import java.io.Serializable;
import java.util.List;

public class CategoryResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String description;
    private List<CategoryRequestDTO> subcategories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CategoryRequestDTO> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<CategoryRequestDTO> subcategories) {
        this.subcategories = subcategories;
    }
}
