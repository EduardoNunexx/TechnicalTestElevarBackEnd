package com.elevarvendas.technicalTest.model.services.imp;

import com.elevarvendas.technicalTest.dto.product.ProductRequestDTO;
import com.elevarvendas.technicalTest.dto.product.ProductResponseDTO;
import com.elevarvendas.technicalTest.exceptions.DatabaseOperationException;
import com.elevarvendas.technicalTest.exceptions.ResourceNotFoundException;
import com.elevarvendas.technicalTest.mapper.Mapper;
import com.elevarvendas.technicalTest.model.entities.Product;
import com.elevarvendas.technicalTest.model.repository.ProductRepository;
import com.elevarvendas.technicalTest.model.services.ProductServices;
import jakarta.persistence.PersistenceException;
import org.hibernate.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        try {
            List<Product> products = productRepository.findAll();
            return mapper.convertToList(products,ProductResponseDTO.class);
        }catch (MappingException mappingException){
            throw new MappingException("Internal server error");
        } catch (PersistenceException persistenceException){
            throw new DatabaseOperationException("Database access error");
        }

    }
    @Override
    public ProductResponseDTO getProductById(Long id) {
        try {
            Optional<Product> product = productRepository.findById(id);
            return product.map(value -> mapper.convertToObject(value, ProductResponseDTO.class)).orElseThrow(()->new ResourceNotFoundException("Product not found"));
        }catch (MappingException mappingException){
            throw new MappingException("Internal server error");
        } catch (PersistenceException persistenceException){
            throw new DatabaseOperationException("Database access error");
        }
    }
    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        try {
            Product product = productRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found"));
            mapper.mapToObject(productRequestDTO, product);
            Product updatedProduct = productRepository.save(product);
            return mapper.convertToObject(updatedProduct, ProductResponseDTO.class);
        }catch (MappingException mappingException){
            throw new MappingException("Internal server error");
        } catch (PersistenceException persistenceException){
            throw new DatabaseOperationException("Database access error");
        }

    }
    @Override
    public void deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
        }catch (PersistenceException persistenceException){
            throw new DatabaseOperationException("Database access error");
        }

    }
}
