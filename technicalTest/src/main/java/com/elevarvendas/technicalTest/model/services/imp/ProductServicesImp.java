package com.elevarvendas.technicalTest.model.services.imp;

import com.elevarvendas.technicalTest.dto.product.ProductRequestDTO;
import com.elevarvendas.technicalTest.dto.product.ProductResponseDTO;
import com.elevarvendas.technicalTest.mapper.Mapper;
import com.elevarvendas.technicalTest.model.entities.Product;
import com.elevarvendas.technicalTest.model.repository.ProductRepository;
import com.elevarvendas.technicalTest.model.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServicesImp implements ProductServices {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    Mapper mapper;

    @Override
    public ProductResponseDTO saveProduct(ProductRequestDTO productRequestDTO) {
        Product product = mapper.convertToObject(productRequestDTO, Product.class);
        Product savedProduct = productRepository.save(product);

        return mapper.convertToObject(savedProduct, ProductResponseDTO.class);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return mapper.convertToList(products,ProductResponseDTO.class);
    }
    @Override
    public ProductResponseDTO getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        //todo implement resourceNotFoundException
        return product.map(value -> mapper.convertToObject(value, ProductResponseDTO.class)).orElse(null);
    }
    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            mapper.mapToObject(productRequestDTO, product);
            //todo review
            Product updatedProduct = productRepository.save(product);
            return mapper.convertToObject(updatedProduct, ProductResponseDTO.class);
        }
        return null; //todo implement exception too
    }
    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
