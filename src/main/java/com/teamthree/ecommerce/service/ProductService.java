package com.teamthree.ecommerce.service;

import java.util.List;

import com.teamthree.ecommerce.model.Product;
import com.teamthree.ecommerce.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

	@Transactional
    public void saveProduct(Product product) {
        productRepository.save(product);
    }
     
	@Transactional
    public List<Product> listProducts() {
        return (List<Product>) productRepository.findAll();
    }
	@Transactional
    public Product get(int id) {
        return productRepository.findById(id).get();
    }
     
	@Transactional
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

	public void save(Product product) {
	}
    
}
