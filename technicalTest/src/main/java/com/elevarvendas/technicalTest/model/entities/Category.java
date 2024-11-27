package com.elevarvendas.technicalTest.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @Column(nullable = false)
        private String description;

        @OneToMany(cascade = CascadeType.ALL)
        @JoinColumn(name = "parent_id")
        private List<Category> subCategories;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<Category> getSubCategories() {
            return subCategories;
        }

        public void setSubCategories(List<Category> subCategories) {
            this.subCategories = subCategories;
        }
}
