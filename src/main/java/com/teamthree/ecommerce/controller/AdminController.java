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
	
	//TODO
	
	//Endpoints
	//view-users
	//add-user
	//view-user
	//
	@Autowired 
	UserService userService;
	@Autowired 
	ProductService productService;
	
//	@RequestMapping
//	public String adminWelcomePage() {
//		return "admin/admin"; 
//	}
	
	@RequestMapping ("/users")
	public String usersPage(){
		return "view-users";
	}
	

	@RequestMapping("/addUser")
	public ModelAndView createUser(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView("admin/editUser");
	//	mv.addObject("fullname", userService.findOne(id));
	//	mv.addObject("email", Condition.values());
	//	mv.addObject("category", Category.values());
	//	mv.addObject("size", Size.values());
		return mv;
	}
	
	@PostMapping("/editUser/{id}")
	public ModelAndView updateUser(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView("/editUser");
		return mv;
	}
	
//	@RequestMapping ("/products")
//	public String productsPage(){
//		return "admin/products";
//	}
    
}
