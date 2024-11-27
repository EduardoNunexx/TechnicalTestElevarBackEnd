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
    @NotNull(message = "The title cant be null")
    private String title;
    @NotNull(message = "The code cant be null")
    private String code;
    @Size(max = 200)
    private String description;

    @NotNull(message = "The price cant be null")
    private BigDecimal price;

    private BigDecimal promotionalPrice;

    @NotNull(message = "The status cant be null")
    private Status status;

    private Boolean onSale;

    private List<String> photos;

    private List<Category> category;
    @NotNull
    private Integer stockQuantity;

    private Boolean emphasis;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(BigDecimal promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Boolean getOnSale() {
        return onSale;
    }

    public void setOnSale(Boolean onSale) {
        this.onSale = onSale;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public List<Category> getCategory() {
        return category;
    }

    public void setCategory(List<Category> category) {
        this.category = category;
    }

    public Integer getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Boolean getEmphasis() {
        return emphasis;
    }

    public void setEmphasis(Boolean emphasis) {
        this.emphasis = emphasis;
    }

    public ProductRequestDTO() {
    }
}
