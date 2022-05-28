package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Category;
import com.example.demo.models.Farm;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryrepo;
	
	public List<Category> allCategories() {
        return categoryrepo.findAll();
    }
	
	
	
	public Category addCategory(Category c) {
        return categoryrepo.save(c);
    }
	
	public Category findbyId(Long id) {
		return categoryrepo.findById(id).get();
	}
	
	
	public void addProductsToCategory(Category this_category,Product selcted_product) {
		this_category.getProducts().add(selcted_product);
		categoryrepo.save(this_category);
	}
}
