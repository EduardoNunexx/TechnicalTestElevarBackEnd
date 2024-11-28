package com.elevarvendas.technicalTest.dto.product;

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
    private Boolean status;
    private String title;
    private BigDecimal price;
    private List<Category> category;
    private Boolean emphasis;
    private List<String> photos;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(BigDecimal promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public Boolean getEmphasis() {
        return emphasis;
    }

    public void setEmphasis(Boolean emphasis) {
        this.emphasis = emphasis;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public ProductResponseDTO() {
    }
}
