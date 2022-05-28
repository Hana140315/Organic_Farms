package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productrepo;
	
	

	
	public List<Product> allProducts(){
		return productrepo.findAll();
	}
	
	public Product addProduct(Product p) {
		return productrepo.save(p);
	}
	public Product findbyId(Long id) {
		return productrepo.findById(id).get();
	}
	
	public List<Product> findbycategories(Category category){
		return productrepo.findAllByCategoryType(category);
	}
    
	public List<Product> findbyCategoriesNotContan(Category category){
		return productrepo.findByCategoryTypeNotContains(category);
	}
	
	   public void deleteProduct(Long id) {
	        
		   productrepo.deleteById(id);
	    }
	
}
