package com.nimap.nimap_test.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.nimap_test.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
