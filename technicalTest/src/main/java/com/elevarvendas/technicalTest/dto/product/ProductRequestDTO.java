package com.elevarvendas.technicalTest.dto.product;

import com.elevarvendas.technicalTest.enums.Status;
import com.elevarvendas.technicalTest.model.entities.Categories;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductRequestDTO implements Serializable {
    private static final long serialVersionUID= 1L;
    private String code;
    private String description;
    private Long id;
    private BigDecimal promotionalPrice;
    private Boolean onSale;
    private Integer stockQuantity;
    private Status status;
    private String title;
    private BigDecimal price;
    private List<Categories> category;
    private Boolean emphasis;
    private List<String> photos;

}
