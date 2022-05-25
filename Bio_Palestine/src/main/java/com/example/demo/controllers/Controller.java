package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controller {

	

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
}
