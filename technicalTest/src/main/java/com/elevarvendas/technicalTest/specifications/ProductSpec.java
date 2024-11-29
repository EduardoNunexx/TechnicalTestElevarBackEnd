package com.elevarvendas.technicalTest.specifications;

import com.elevarvendas.technicalTest.model.entities.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;
import java.util.ArrayList;
import java.util.List;

public class ProductSpec {
    public static Specification<Product> filterByText(String text){
        return (root, query, criteriaBuilder) ->{
            if(ObjectUtils.isEmpty(text)){
                return null;
            }
            String likePattern = "%" + text.toLowerCase() + "%";

            List<Predicate> predicates = new ArrayList<>();

            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("title")), likePattern));
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("code")), likePattern));
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("description")), likePattern));
            return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
        };
    }
}
