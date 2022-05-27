package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Category;
import com.example.demo.models.Farm;
import com.example.demo.models.LoginUser;
import com.example.demo.models.Product;
import com.example.demo.services.CategoryService;
import com.example.demo.services.FarmService;
import com.example.demo.services.ProductService;




@org.springframework.stereotype.Controller
public class Controller {
	

	private FarmService farmServ;
	private CategoryService catServce;
	private ProductService proServce;
	
	
	
	public Controller(FarmService farmServ, CategoryService catServce, ProductService proServce) {
		this.farmServ = farmServ;
		this.catServce = catServce;
		this.proServce = proServce;
	}

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
			List<Product> products = proServce.allProducts();
			List<Category> categories = catServce.allCategories();
			model.addAttribute("product",products);
			model.addAttribute("category",categories);
    		Long userId=(Long)session.getAttribute("userId");
    		Farm currenUser=farmServ.findbyId(userId);
    		model.addAttribute("currentUser", currenUser);
    		return "home.jsp";
    	}

    	return "redirect:/";
	}
	@GetMapping("/product/new")
	public String newproduct(Model model,@ModelAttribute("product") Product product) {
		List<Category> categories = catServce.allCategories();
		model.addAttribute("allCategories",categories);
		return "addproduct.jsp";
	}
	
	@GetMapping("/category/new")
	public String newcategory(@ModelAttribute("category") Category category) {
		
		return "addcategory.jsp";
	}
	
	
	
}
