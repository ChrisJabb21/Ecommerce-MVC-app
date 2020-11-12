package com.teamthree.ecommerce.controller;

import com.teamthree.ecommerce.model.Product;
import com.teamthree.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
/** Controller for view of common pages a guest, customer or admin can view. */
public class MainController {

	@Autowired
	ProductService productService;

	//defaults to login or signup
	@RequestMapping("/")
	public String showIndex(){
		return "index";
	}
	
	@RequestMapping("/contact")
	public String showContactUs(){
		return "contactUs";
	}
	
	@RequestMapping("/about")
	public String showAboutUs(){
		return "aboutUs";
	}

	//show products page as a user or guest
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.listProducts());
		return "products";
	}
}
