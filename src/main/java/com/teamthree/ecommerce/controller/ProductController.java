package com.teamthree.ecommerce.controller;

import com.teamthree.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class ProductController {
    
    @Autowired
    ProductService proudctService;

    @RequestMapping("/products")
	public String showProducts(){
		return "products";
	}
}
