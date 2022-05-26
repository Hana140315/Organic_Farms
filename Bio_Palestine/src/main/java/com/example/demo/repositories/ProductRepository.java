package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Category;
import com.example.demo.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long>{
	
	//retrieve all products
	List<Product> findAll();
	
	//retrieve all products in a particular category
	List<Product> findAllByCategoryType(Category category);
	
	//retrieve a list of products not included in a particular category
	List<Product> findByCategoryTypeNotContains(Category category);
}
