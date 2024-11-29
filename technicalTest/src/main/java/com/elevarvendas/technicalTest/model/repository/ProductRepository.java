package com.elevarvendas.technicalTest.model.repository;

import com.elevarvendas.technicalTest.model.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
    @Override
    Page<Product> findAll(Pageable pageable);
}
