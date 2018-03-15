package com.hhatim.login.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhatim.login.models.Category;
import com.hhatim.login.repositories.CategoryRepository;
import com.hhatim.login.repositories.ProductRepository;

@Service
public class CategoryService {
	
	// ***************Dependencies Injection********************
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}

	// *********************************************************	
	
	// Add Category to table
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	// Update Category
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}
	
	// Get All Category from table
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	// find category associated with the product id
	public Category getOneCategory(Long id) {
		return categoryRepository.findOne(id);
	}
	
	// Return All Categories Excluding the Categories associated with the product id
	public List<Category> getAllExcept(Long productId) {
		List<Category> categories = this.findAll();	// this.findAll() is an instance method of findAll() and used for better readability
		// through the product Repository, access the specified product by ID, then use the getter method from the product model to get all categories connected with that product 
		List<Category> filteredCategories = productRepository.findOne(productId).getCategories();
		//remove all categories connected with the product ID, leaving only the Categories that do not have any connections with the product.
		categories.removeAll(filteredCategories); //this overrides the bean categories in the product model
		return categories;	
		
	}
}
