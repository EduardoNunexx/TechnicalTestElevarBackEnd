package com.elevarvendas.technicalTest.model.repository;

import com.elevarvendas.technicalTest.model.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrategoriesRespository extends JpaRepository<Categories, Integer> {

}
