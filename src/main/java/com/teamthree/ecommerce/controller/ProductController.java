package com.teamthree.ecommerce.controller;

import java.util.Map;

import com.teamthree.ecommerce.model.Product;
import com.teamthree.ecommerce.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

	// TODO
	// Endpoints
	// add-user
	// edit-user
	// get-user

	@Autowired
	ProductService productService;

	// For Admin to access

	@RequestMapping(value = "/product_inventory", method = RequestMethod.GET)
	public String listProducts(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProducts", productService.listProducts());
		return "product_inventory";
	}

		/*
    @Transient
    private MultipartFile product_image;

    private String name;

    private String category;

    private String condition;
    private double price;
*/

	@RequestMapping("/addProduct")
	public String newProductForm(Map<String, Object> model) {

		Product product = new Product();
		model.put("product", product);
		return "new_product";
		//ModelAndView mv = new ModelAndView("editProduct");
		//mv.addObject("fullname", userService.findOne(id));
		//mv.addObject("email", Condition.values());
		//mv.addObject("category", Category.values());
		//mv.addObject("size", Size.values());
		//return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
public String saveProduct(@ModelAttribute("product") Product product) {
    productService.saveProduct(product);
    return "redirect:/product_inventory";
}

	@PostMapping("/editProduct/{id}")
	public ModelAndView updateProduct(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView("/editProduct");
		return mv;
	}

	// TODO

	@DeleteMapping("/deleteProduct/{id}")
	public String removeProduct(@PathVariable("id") int id) {

		productService.deleteProduct(id);
		return "redirect:/product_inventory";
	}

}
