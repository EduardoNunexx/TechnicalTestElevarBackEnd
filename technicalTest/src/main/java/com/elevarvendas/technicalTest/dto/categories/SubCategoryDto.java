package com.elevarvendas.technicalTest.dto.categories;

import com.elevarvendas.technicalTest.model.entities.Category;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubCategoryDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String description;
    private Integer parentCategoryId;
    private Integer id;
   private List<SubCategoryDto> subcategories;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<SubCategoryDto> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubCategoryDto> subcategories) {
        this.subcategories = subcategories;
    }
}
