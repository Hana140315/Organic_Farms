package com.example.demo.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.models.Category;
import com.example.demo.models.Farm;
import com.example.demo.models.Product;
import com.example.demo.services.CategoryService;
import com.example.demo.services.FarmService;
import com.example.demo.services.ProductService;

@Controller
public class ProductCategoryController {

	private FarmService farmServ;
	private CategoryService catServce;
	private ProductService proServce;
	
	
	
	public ProductCategoryController(FarmService farmServ, CategoryService catServce, ProductService proServce) {
		this.farmServ = farmServ;
		this.catServce = catServce;
		this.proServce = proServce;
	}
	
	@PostMapping("/product/new")
	public String createproduct(@Valid @ModelAttribute("product") Product product,BindingResult result,HttpSession session) {
		 if (result.hasErrors()) {
	            return "addproduct.jsp";
	        } else {
	        	if(session.getAttribute("userId")!=null) {
		        	Long farmId=(Long)session.getAttribute("userId");
		    		Farm currenFarm=farmServ.findbyId(farmId);
		    		currenFarm.addproductToFarm(product);
		    		farmServ.update(currenFarm);
		    		product.setFarm(currenFarm);
		    		proServce.addProduct(product);
	        	}
	        	return "redirect:/home";
	        }
	}
	

	
	@PostMapping("/category/new")
	public String createcategory(@Valid @ModelAttribute("category") Category category,BindingResult result) {
		 if (result.hasErrors()) {
	            return "addcategory.jsp";
	        } else 
	        {
	        	catServce.addCategory(category);
	    return "redirect:/home";
	        }
	}
	
	@PutMapping("/edit/{id}")
    public String update(@Valid @ModelAttribute("product") Product product ,HttpSession session, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
        	Long userId=(Long)session.getAttribute("userId");
    		Farm currenUser=farmServ.findbyId(userId);
    		product.setFarm(currenUser);
    		proServce.updateProduct(product);
            return "redirect:/home";
        }
    }
}
