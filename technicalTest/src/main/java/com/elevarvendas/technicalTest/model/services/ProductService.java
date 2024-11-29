package com.elevarvendas.technicalTest.model.services;

import com.elevarvendas.technicalTest.dto.page.ProductsResponsePageDTO;
import com.elevarvendas.technicalTest.dto.product.ProductRequestDTO;
import com.elevarvendas.technicalTest.dto.product.ProductResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO);
    //todo change this when you'll add the pagination
    ProductsResponsePageDTO getAllProducts(Pageable pageable, String text);

    ProductResponseDTO getProductById(Long id);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);

    void deleteProduct(Long id);
}
