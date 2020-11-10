package com.teamthree.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
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
	//show products page
}
