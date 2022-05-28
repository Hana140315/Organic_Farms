package com.example.demo.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Farm;

import com.example.demo.services.FarmService;

import com.example.demo.validators.UserValidator;

@Controller
public class UsersController {
    
    private FarmService farmService;
 private UserValidator userValidator;
    
    // NEW
    public UsersController(FarmService userService, UserValidator userValidator) {
        this.farmService = userService;
        this.userValidator = userValidator;
    }
    @RequestMapping(value = {"/home"})
    public String home(Principal principal, Model model) {
        // 1
        String username = principal.getName();
        model.addAttribute("currentUser", farmService.findByUsername(username));
        return "home.jsp";
    }
    
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "login.jsp";
    }
    
    @RequestMapping("/register")
    public String registerForm(@ModelAttribute("newUser") Farm user) {
        return "register.jsp";
    }
    
    @PostMapping("/register")
    public String registration(@Valid @ModelAttribute("newUser") Farm user, BindingResult result, Model model, HttpSession session) {
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
            return "register.jsp";
        }
    	farmService.saveWithUserRole(user);
//    	farmService.saveUserWithAdminRole(user);
//    	session.setAttribute("userId", user.getId());
    	System.out.print(user.getId());
        return "redirect:/login";
    }
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", farmService.findByUsername(username));
        return "adminPage.jsp";
    }
    
//    @RequestMapping("/login")
//    public String login() {
//        return "loginPage.jsp";
//    }
}