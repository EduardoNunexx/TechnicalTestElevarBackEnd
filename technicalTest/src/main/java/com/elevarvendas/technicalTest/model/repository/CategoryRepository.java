package com.elevarvendas.technicalTest.model.repository;

import com.elevarvendas.technicalTest.model.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
