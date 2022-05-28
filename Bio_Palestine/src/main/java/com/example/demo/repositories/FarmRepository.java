package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.models.Farm;


@Repository
public interface FarmRepository extends CrudRepository<Farm, Long> {
	
	//retrieve all farms
	List<Farm> findAll();
	
	Farm findByEmail(String email);
	    
	Optional<Farm> findById(Long id);
	
	Farm findByfarmName(String username);
	
}
