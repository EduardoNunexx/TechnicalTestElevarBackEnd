package com.elevarvendas.technicalTest.specifications;

import com.elevarvendas.technicalTest.model.entities.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

public class ProductSpec {
    public static Specification<Product> titleContains(String title){
        return (root, query, criteriaBuilder) ->{
            if(ObjectUtils.isEmpty(title)){
                return null;
            }
            return criteriaBuilder.like(root.get("title"), "%"+title+"%");
        };
    }
}
