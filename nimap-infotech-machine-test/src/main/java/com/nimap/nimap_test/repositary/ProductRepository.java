package com.nimap.nimap_test.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.nimap_test.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
