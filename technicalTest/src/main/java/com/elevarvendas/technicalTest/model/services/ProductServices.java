package com.elevarvendas.technicalTest.model.services;

import com.elevarvendas.technicalTest.dto.product.ProductResponseDTO;
import com.elevarvendas.technicalTest.dto.product.ProductRequestDTO;

import java.util.List;

public interface ProductServices {
    ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO);
    //todo change this when you'll add the pagination
    List<ProductResponseDTO> getAllProducts();

    ProductResponseDTO getProductById(Long id);

    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);

    void deleteProduct(Long id);
}
