package com.teamthree.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.teamthree.ecommerce.service.UserService;

/*
Controller for acc
*/
@Controller
public class AdminController {
	
	@Autowired 
	UserService userService;
	//need products
	
	@RequestMapping
	public String adminWelcomePage() {
		return "admin/admin";
	}
	
	@RequestMapping ("/users")
	public String usersPage(){
		return "admin/users";
	}
	
	@RequestMapping("/user/edit/{id}")
	public ModelAndView updateProduct(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView("admin/editUser");
	//	mv.addObject("fullname", userService.findOne(id));
	//	mv.addObject("email", Condition.values());
	//	mv.addObject("category", Category.values());
	//	mv.addObject("size", Size.values());
		return mv;
	}
	
	@RequestMapping ("/products")
	public String productsPage(){
		return "admin/products";
	}
    
}
