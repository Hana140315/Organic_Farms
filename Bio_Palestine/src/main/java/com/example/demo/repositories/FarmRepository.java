package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.models.Farm;

@Repository
public interface FarmRepository extends CrudRepository<Farm, Long> {
	List<Farm> findAll();
}
