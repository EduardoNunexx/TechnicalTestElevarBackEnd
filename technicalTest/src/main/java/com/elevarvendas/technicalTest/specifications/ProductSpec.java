package com.elevarvendas.technicalTest.specifications;

import com.elevarvendas.technicalTest.model.entities.Category;
import com.elevarvendas.technicalTest.model.entities.Product;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class ProductSpec {
    public static Specification<Product> filterByText(String text) {
        return (root, query, criteriaBuilder) -> {
            if (ObjectUtils.isEmpty(text)) {
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

    public static Specification<Product> hasStatus(Boolean status) {
        return (root, query, criteriaBuilder) -> {
            if (status == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("status"), status);
        };
    }

    public static Specification<Product> isOnSale(Boolean onSale) {
        return (root, query, criteriaBuilder) -> {
            if (onSale == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("onSale"), onSale);
        };
    }
    public static Specification<Product> hasCategoryId(Long categoryId) {
        return (root, query, criteriaBuilder) -> {
            if (categoryId == null) {
                return criteriaBuilder.conjunction(); // Se o ID da categoria for nulo, não filtra
            }
            return criteriaBuilder.equal(root.get("category").get("id"), categoryId);
        };
    }
}

