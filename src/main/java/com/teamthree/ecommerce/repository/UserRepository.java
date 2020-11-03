package com.teamthree.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamthree.ecommerce.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    
}
