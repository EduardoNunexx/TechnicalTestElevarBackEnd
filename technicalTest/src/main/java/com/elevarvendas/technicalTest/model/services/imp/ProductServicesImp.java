package com.elevarvendas.technicalTest.model.services.imp;

import com.elevarvendas.technicalTest.dto.page.ProductsResponsePageDTO;
import com.elevarvendas.technicalTest.dto.product.ProductResponseDTO;
import com.elevarvendas.technicalTest.dto.product.ProductRequestDTO;
import com.elevarvendas.technicalTest.exceptions.DatabaseOperationException;
import com.elevarvendas.technicalTest.exceptions.ResourceNotFoundException;
import com.elevarvendas.technicalTest.mapper.Mapper;
import com.elevarvendas.technicalTest.model.entities.Category;
import com.elevarvendas.technicalTest.model.entities.Product;
import com.elevarvendas.technicalTest.model.repository.ProductRepository;
import com.elevarvendas.technicalTest.model.services.ProductService;
import jakarta.persistence.PersistenceException;
import org.hibernate.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//todo review about these try catch
@Service
public class ProductServicesImp implements ProductService {
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
    public ProductsResponsePageDTO getAllProducts(Pageable pageable) {
        try {
            Page<Product> products = productRepository.findAll(pageable);
            Page<ProductResponseDTO> page = products.map(x->mapper.convertToObject(x,ProductResponseDTO.class));
            ProductsResponsePageDTO productsResponsePageDTO = new ProductsResponsePageDTO();
            productsResponsePageDTO.setData(page.getContent());
            productsResponsePageDTO.setPage(page.getNumber());
            productsResponsePageDTO.setTotalPages(page.getTotalPages());
            productsResponsePageDTO.setTotal(page.getTotalElements());
            return productsResponsePageDTO;
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
