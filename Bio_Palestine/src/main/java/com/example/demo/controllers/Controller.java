package com.example.demo.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String index(Model model) {
		List<Product> products = proServce.allProducts();
		List<Category> categories = catServce.allCategories();
		model.addAttribute("product",products);
		model.addAttribute("category",categories);
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
	public String product(Model model) {
		List<Product> products = proServce.allProducts();
		model.addAttribute("product",products);
		return "product.jsp";
	}
	
//	@GetMapping("/home")
//	public String home(Model model,HttpSession session) {
//		if(session.getAttribute("userId")!=null) {
//			Long userId=(Long)session.getAttribute("userId");
//			Farm currenUser=farmServ.findbyId(userId);
//			List<Product> products = proServce.allProductforFarm(currenUser);
//			List<Category> categories = catServce.allCategories();
//			model.addAttribute("product",products);
//			model.addAttribute("category",categories);
//    		
//    		
//    		model.addAttribute("currentUser", currenUser);
//    		return "home.jsp";
//    	}
//
//    	return "redirect:/";
//	}
	@RequestMapping("/product/new")
	public String newproduct(Model model,Principal principal,@ModelAttribute("product") Product product,HttpSession session) {
		List<Category> categories = catServce.allCategories();
		model.addAttribute("allCategories",categories);
		
		 String username = principal.getName();
	      session.setAttribute("currenUser", farmServ.findByEmail(username));
		return "addproduct.jsp";
	}
	
	@GetMapping("/category/new")
	public String newcategory(Principal principal,@ModelAttribute("category") Category category,HttpSession session) {
		 String username = principal.getName();
	      session.setAttribute("currenUser", farmServ.findByEmail(username));
		
		return "addcategory.jsp";
	}
	
	 @GetMapping("/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
		 proServce.deleteProduct(id);
	        return "redirect:/home";
	    }
		@GetMapping("/edit/{id}/update")
	    public String edit(@PathVariable("id") Long id,Model model) {
			Product thisproduct = proServce.findbyId(id);
	        model.addAttribute("selectedProduct", thisproduct);
	        List<Category> categories = catServce.allCategories();
			model.addAttribute("allCategories",categories);
	        return "edit.jsp";
	    }
		 
		@GetMapping("/detail/{id}")
		public String detail(Model model,@PathVariable("id") Long id,@ModelAttribute("product") Product product) {
			Product currProduct=proServce.findbyId(id);
			model.addAttribute("thisProduct",currProduct);
			return "detail.jsp";
		}
}
