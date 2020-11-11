package com.teamthree.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/** Controller for view of common pages a guest, customer or admin can view. */
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

	//show products page as a user or guest
}
