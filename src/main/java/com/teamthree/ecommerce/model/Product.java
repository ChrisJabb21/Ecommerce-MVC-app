package com.teamthree.ecommerce.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;


    @Transient
    private MultipartFile product_thumbnail;

    private String name;

    private String category;

    private String condition;
    private double price;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public MultipartFile getProduct_thumbnail() {
        return product_thumbnail;
    }

    public void setProduct_thumbnail(MultipartFile product_thumbnail) {
        this.product_thumbnail = product_thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCondition() {
        return condition;
    }


    public void setCondition(String condition) {
        this.condition = condition;
    }


    public double getPrice() {
        return price;
    
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
