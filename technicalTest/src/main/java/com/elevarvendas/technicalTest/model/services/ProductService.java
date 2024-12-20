package com.elevarvendas.technicalTest.model.services;

import com.elevarvendas.technicalTest.dto.page.ProductsResponsePageDTO;
import com.elevarvendas.technicalTest.dto.product.ProductRequestDTO;
import com.elevarvendas.technicalTest.dto.product.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO);
    ProductsResponsePageDTO getAllProducts(Pageable pageable, String text, Boolean status, Boolean onSale);

    ProductResponseDTO getProductById(Long id);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);

    void deleteProduct(Long id);
}
