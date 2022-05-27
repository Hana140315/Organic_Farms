package com.example.demo.controllers;

import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;

@Controller
public class ProductCategoryController {

	private CategoryService catServce;
	private ProductService proServce;
	
	
	public ProductCategoryController(CategoryService catServce, ProductService proServce) {
		
		this.catServce = catServce;
		this.proServce = proServce;
	}
	
	@PostMapping("/product/new")
	public String createproduct(@Valid @ModelAttribute("product") Product product,BindingResult result) {
		 if (result.hasErrors()) {
	            return "newproduct.jsp";
	        } else {
	        	proServce.addProduct(product);
	    return "redirect:/";
	        }
	}
	

	
	@PostMapping("/category/new")
	public String createcategory(@Valid @ModelAttribute("category") Category category,BindingResult result,Session session) {
		 if (result.hasErrors()) {
	            return "newcategory.jsp";
	        } else {
	        	
	        	catServce.addCategory(category);
	    return "redirect:/";
	        }
	}
}
