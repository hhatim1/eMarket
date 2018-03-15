package com.hhatim.login.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hhatim.login.models.Product;
import com.hhatim.login.repositories.CategoryRepository;
import com.hhatim.login.repositories.ProductRepository;

@Service
public class ProductService {

	// ***************Dependencies Injection********************
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	// *********************************************************	
	
	// save product
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	//FIND ALL
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	//find product by id
	public Product findOne(Long id) {
		return productRepository.findOne(id);
	}
	
	// save category to product
	public void updateProduct(Product product) {
		productRepository.save(product);
	}
	
	//Return All Products Excluding the products associated with the category id
	public List<Product> getAllExcept(Long categoryId) {
		List<Product> products = this.findAll();
		List<Product> filteredProducts = categoryRepository.findOne(categoryId).getProducts();
		products.removeAll(filteredProducts);
		return products;
	}
	
	
	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public CategoryRepository getCategoryRepository() {
		return categoryRepository;
	}

	public void setCategoryRepository(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	// delete product
	public void deleteProduct(Long id) {
		productRepository.delete(id);
	}
	
	
	
}

