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

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
     
    public List<Product> listAll() {
        return (List<Product>) productRepository.findAll();
    }
     
    public Product get(int id) {
        return productRepository.findById(id).get();
    }
     
    public void delete(int id) {
        productRepository.deleteById(id);
    }
    
}
