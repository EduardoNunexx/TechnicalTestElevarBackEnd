package com.elevarvendas.technicalTest.dto.product;

import com.elevarvendas.technicalTest.enums.Status;
import com.elevarvendas.technicalTest.model.entities.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductRequestDTO implements Serializable {
    private static final long serialVersionUID= 1L;
    private String title;

    private String code;
    @Size(max = 200)
    private String description;

    @NotNull
    private BigDecimal price;

    private BigDecimal promotionalPrice;

    @NotNull
    private Status status;

    private Boolean onSale;

    private List<String> photos;

    private List<Category> category;
    @NotNull
    private Integer stockQuantity;

    private Boolean emphasis;
}
