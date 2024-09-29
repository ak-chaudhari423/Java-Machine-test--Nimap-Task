package com.nimap.nimap_test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nimap.nimap_test.DTO.ProductDTO;
import com.nimap.nimap_test.model.Category;
import com.nimap.nimap_test.model.Product;
import com.nimap.nimap_test.repositary.CategoryRepository;
import com.nimap.nimap_test.repositary.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public Page<Product> getAllProducts(int page) {
		return productRepository.findAll(PageRequest.of(page, 10));
	}

	public Product createProduct(ProductDTO productDTO) {

		Category category = categoryRepository.findById(productDTO.getCategoryId())
				.orElseThrow(() -> new IllegalArgumentException("Category not found"));

		Product product = new Product();
		product.setProductName(productDTO.getProductName());
		product.setProductPrice(productDTO.getProductPrice());
		product.setCategory(category);

		return productRepository.save(product);
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product updateProduct(Long id, ProductDTO productDTO) {
		Product product = productRepository.findById(productDTO.getProductId())
				.orElseThrow(() -> new IllegalArgumentException("Product not found"));

		Category category = categoryRepository.findById(productDTO.getCategoryId())
				.orElseThrow(() -> new IllegalArgumentException("Category not found"));

		product.setProductId(id);
		product.setProductName(productDTO.getProductName());
		product.setProductPrice(productDTO.getProductPrice());
		product.setCategory(category);

		return productRepository.save(product);
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}
}
