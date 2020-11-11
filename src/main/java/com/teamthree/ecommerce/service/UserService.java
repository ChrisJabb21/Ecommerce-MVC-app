package com.teamthree.ecommerce.service;

import java.util.List;

import com.teamthree.ecommerce.model.User;

public interface UserService {

	public User getUserById(int id);
	public void updateUser(User user);
	public void addUser(User user);
	List<User> getAllProducts();
	void save(User user);
	User findByUsername(String username);

}
