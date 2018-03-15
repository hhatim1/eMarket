package com.hhatim.login.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hhatim.login.models.Category;
import com.hhatim.login.models.Product;
import com.hhatim.login.services.BuyService;
import com.hhatim.login.services.CategoryService;
import com.hhatim.login.services.ProductService;

@Controller
public class ProductsCategoriesController {
	
	// ***************Dependencies Injection**************************************************************
	
		private final ProductService productService;
		private final CategoryService categoryService;
		public ProductsCategoriesController(ProductService productService, CategoryService categoryService) {
			this.productService = productService;
			this.categoryService = categoryService;
		}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	// ***************************************************************************************************	
		//VIEW ALL PRODUCTS AND CATEGORIES
		@RequestMapping("/dashboard")
		public String viewAll(Model model) {
	//	public String main() {
			model.addAttribute("allProducts", productService.findAll());
			model.addAttribute("allCategories", categoryService.findAll());
			return "index.jsp";
		}
	
		
		// ***************************************************************************************************	
		// PRODUCT
		
		// VIEW-NEW PRODUCT USING FORM
		@RequestMapping("/products/new")
		public String newProductView(@ModelAttribute Product product) {
			return "newProduct.jsp";
		}
		
		// PROCESS-VALIDATE & CREATE NEW PRODUCT
		@PostMapping("/products/create")
		public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
			if(result.hasErrors()) {
				//System.out.println(result);
				return "newProduct.jsp";
			} else {
				productService.addProduct(product);
				return "redirect:/products/new";
			}
		}
	
		// VIEW-DISPLAY PRODUCT INFO USING FORM
		@RequestMapping("/product/{id}")
		public String showProductInfo(Model model, @PathVariable("id") Long productId) {
			Product product = productService.findOne(productId); // get the specific product by id. This lets you access the products Categories and Name
			model.addAttribute("thisProduct", product);	//give .jsp page access to this product information
			model.addAttribute("filterCategories", categoryService.getAllExcept(productId)); // run the getAllExcept() method in categoryService and pass it the product ID
			return "productinfo.jsp";
		}
	
		// PROCESS-ADD CATEGORY TO PRODUCT
		@PostMapping("/product/{id}/add_category")
		public String AddCategory(@PathVariable("id") Long productId, @RequestParam("category_id") Long categoryId) {	// category_id is the form select name. view productInfo.jsp
			Product p = productService.findOne(productId);
			Category c = categoryService.getOneCategory(categoryId);
			p.getCategories().add(c);
			productService.updateProduct(p);
			return "redirect:/product/" + productId;
		}
		
		// ***************************************************************************************************	
		// CATEGORY
		
		// VIEW-NEW CATEGORY FORM
		@RequestMapping("/category/new")
		public String newCategoryView(@ModelAttribute Category category) {
			return "newCategory.jsp";
		}
		
		// PROCESS-VALIDATE & CREATE NEW CATEGORY FORM
		@PostMapping("/category/create")
		public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
			if(result.hasErrors()) {
				return "newCategory.jsp";
			} else {
				categoryService.addCategory(category);
				return "redirect:/category/new";
			}
		}
				
		//VIEW-DISPLAY PRODUCT 	
		@RequestMapping("/category/{id}")
		public String showCategoryInfo(Model model, @PathVariable("id") Long categoryId) {
			Category category = categoryService.getOneCategory(categoryId);
			model.addAttribute("thisCategory", category);
			model.addAttribute("filteredProducts", productService.getAllExcept(categoryId));
			return "categoryinfo.jsp";
		}
		
		//ADD PRODUCTS TO CATEGORY
		@PostMapping("/category/{id}/add_product")
		public String AddProduct(@PathVariable("id") Long categoryId, @RequestParam("product_id") Long productId) {	
			Category c = categoryService.getOneCategory(categoryId);
			Product p = productService.findOne(productId);
			c.getProducts().add(p);	
			categoryService.updateCategory(c);
			return "redirect:/category/" + categoryId;
		}
		
		///////Delete Products
		@RequestMapping("/product/delete/{id}")
		///product/delete
		public String deleteProduct(@PathVariable("id") Long id) {
			//ProductService.deleteProduct(id);
			productService.deleteProduct(id);
			return "redirect:/dashboard";
		// ***************************************************************************************************
		}	
		
	///////Buy Products
			@RequestMapping("/product/buy/{id}")
			///product/delete
			public String buyProduct(@PathVariable("id") Long id) {
				
				BuyService.buyProduct(id);
				return "redirect:/category";
			// ***************************************************************************************************
			}	

}
			
