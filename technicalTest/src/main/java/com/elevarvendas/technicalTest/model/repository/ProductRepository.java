package com.elevarvendas.technicalTest.model.repository;

import com.elevarvendas.technicalTest.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
