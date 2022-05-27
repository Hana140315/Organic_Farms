package com.example.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Farm;
import com.example.demo.models.LoginUser;
import com.example.demo.services.FarmService;




@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	 private FarmService farmServ;

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/about")
	public String about() {
		return "about.jsp";
	}
	@GetMapping("/contactUs")
	public String contactUs() {
		return "contact.jsp";
	}
	@GetMapping("/product")
	public String product() {
		return "product.jsp";
	}
	
	@GetMapping("/home")
	public String home(Model model,HttpSession session) {
		if(session.getAttribute("userId")!=null) {
    		Long userId=(Long)session.getAttribute("userId");
    		Farm currenUser=farmServ.findbyId(userId);
    		model.addAttribute("currentUser", currenUser);
    		return "home.jsp";
    	}

    	return "redirect:/";
	}
	

	@GetMapping("/login")
	public String login(Model model) {
		  model.addAttribute("newLogin", new LoginUser());
		return "login.jsp";
	}
	
	
	@GetMapping("/register")
	public String register(Model model) {
		 model.addAttribute("newUser", new Farm());
	      
		return "register.jsp";
	}
	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") Farm newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        
	    
	        Farm registerUser=farmServ.register(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "register.jsp";
	        }
	     
	        session.setAttribute("userId", registerUser.getId());
	        return "redirect:/home";
	    }
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // Add once service is implemented:
	         Farm user = farmServ.login(newLogin, result);
	    
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new Farm());
	            return "login.jsp";
	        }
	    
	  
	        session.setAttribute("userId", user.getId());
	        return "redirect:/home";
	    }
	    
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";
	    }
}
