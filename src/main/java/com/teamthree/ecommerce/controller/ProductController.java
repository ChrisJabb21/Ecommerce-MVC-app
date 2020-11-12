package com.teamthree.ecommerce.controller;

import com.teamthree.ecommerce.model.Product;
import com.teamthree.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    
	//TODO
	//Endpoints
	//products for browsing
	//view-products for admin
	//add-user
	//edit-user
	//get-user

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
	public String listProducts(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.listProducts());
		return "products";
	}
	

	@RequestMapping("/addProduct")
	public ModelAndView createUser(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView("admin/editUser");
	//	mv.addObject("fullname", userService.findOne(id));
	//	mv.addObject("email", Condition.values());
	//	mv.addObject("category", Category.values());
	//	mv.addObject("size", Size.values());
		return mv;
	}
	
	@PostMapping("/editProduct/{id}")
	public ModelAndView updateProduct(@PathVariable("id") Integer id){
		ModelAndView mv = new ModelAndView("/editUser");
		return mv;
	}
	
	//TODO
	@RequestMapping("/remove/{id}")
    public String removeProduct(@PathVariable("id") int id){
		
        //this.productService.removeProduct(id);
        //return "redirect:/view-products";
    }
	
//	@RequestMapping ("/products")
//	public String productsPage(){
//		return "admin/products";
//	}
}
