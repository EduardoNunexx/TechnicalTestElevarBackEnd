package com.elevarvendas.technicalTest.dto.categories;
import com.elevarvendas.technicalTest.model.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;

public class CategoryRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    @Size(max = 100)
    private String description;
    private List<Category> subCategories;
    private Category parentCategory;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }
}
