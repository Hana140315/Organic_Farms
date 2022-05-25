package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.models.Farm;
import com.example.demo.repositories.FarmRepository;

@Service
public class FarmService {
	
	@Autowired
	private FarmRepository farmRepo; 
	
	public List<Farm> allFarms(){
		return farmRepo.findAll();
		
	}
	
	public Farm createFarm(Farm farm) {
		return farmRepo.save(farm);
	}
}
