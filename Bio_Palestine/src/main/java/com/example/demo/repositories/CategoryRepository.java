package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Category;
import com.example.demo.models.Farm;
import com.example.demo.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository <Category, Long>{
	
	//retrieve all categories
	List<Category> findAll();
	
	//retrieve a list of categories in a specific farm
	
	Optional<Category> findById(Long id);
}
