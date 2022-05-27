package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo.models.Farm;
import com.example.demo.models.LoginUser;
import com.example.demo.repositories.FarmRepository;

@Service
public class FarmService {
	
	@Autowired
	private FarmRepository farmRepo; 
	
	    
	    // TO-DO: Write register and login methods!
	    public Farm register(Farm newUser, BindingResult result) {
	        Optional<Farm> isUser=farmRepo.findByEmail(newUser.getEmail());
	        if(isUser.isPresent()) {
	        result.rejectValue("email", "Matches", "Email alreedy exist");	
	        }
	        if(!newUser.getPassword().equals(newUser.getConfirm())) {
	            result.rejectValue("confirm", "Matches", "The confirm password must match");	
	            }
	        String toCheck=newUser.getFarmName();
	        if(!toCheck.matches(("[a-zA-Z]+"))) {
	        	result.rejectValue("userName", "Matches", "Must contain letter only");
	        }
	        if(result.hasErrors()) {
	        	return null;
	        }
	        else {
	        	String hashed=BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt());
	        	newUser.setPassword(hashed);
	        	farmRepo.save(newUser);
	        	return newUser;
	        }
	    }
	    public Farm login(LoginUser newLoginObject, BindingResult result) {
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    	 Optional<Farm> isUser=farmRepo.findByEmail(newLoginObject.getEmail());
	    	if(!isUser.isPresent()) {
	            result.rejectValue("email", "Matches", "Unknown email");	
	            return null;
	            }
	    	Farm user=isUser.get();
	    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
	    		result.rejectValue("password", "Matches", "Invalid Password!");
	    	}
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    	else {
	        return user;
	    }
	    	}
	    
	   public Farm findbyId(Long id) {
		   return farmRepo.findById(id).orElse(null);  
	   }
}
