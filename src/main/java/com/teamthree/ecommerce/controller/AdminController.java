package com.teamthree.ecommerce.controller;

import com.teamthree.ecommerce.service.ProductService;
import com.teamthree.ecommerce.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
Controller for admin view
*/
@Controller
public class AdminController {
	
	@Autowired 
	UserService userService;
	@Autowired 
	ProductService productsservice;
	
	@RequestMapping
	public String adminWelcomePage() {
		return "admin/admin"; 
	}
	
	@RequestMapping ("/users")
	public String usersPage(){
		return "admin/users";
	}
	

	@RequestMapping("/admin/addUser")
	public ModelAndView createUser(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView("admin/editUser");
	//	mv.addObject("fullname", userService.findOne(id));
	//	mv.addObject("email", Condition.values());
	//	mv.addObject("category", Category.values());
	//	mv.addObject("size", Size.values());
		return mv;
	}
	
	@PostMapping("/admin/editUser/{id}")
	public ModelAndView updateUser(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView("admin/editUser");
		return mv;
	}
	
	@RequestMapping ("/products")
	public String productsPage(){
		return "admin/products";
	}
    
}
