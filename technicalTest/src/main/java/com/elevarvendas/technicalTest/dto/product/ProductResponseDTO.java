package com.elevarvendas.technicalTest.dto.product;

import com.elevarvendas.technicalTest.enums.Status;
import com.elevarvendas.technicalTest.model.entities.Category;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductResponseDTO implements Serializable {
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
    private List<Category> category;
    private Boolean emphasis;
    private List<String> photos;

}
