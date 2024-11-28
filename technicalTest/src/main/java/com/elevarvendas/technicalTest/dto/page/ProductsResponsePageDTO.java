package com.elevarvendas.technicalTest.dto.page;

import com.elevarvendas.technicalTest.dto.product.ProductResponseDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductsResponsePageDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer page;
    private Long total;
    private Integer totalPages;
    private List<ProductResponseDTO> data;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<ProductResponseDTO> getData() {
        return data;
    }

    public void setData(List<ProductResponseDTO> data) {
        this.data = data;
    }
}
