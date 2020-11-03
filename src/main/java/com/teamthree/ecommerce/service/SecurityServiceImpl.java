package com.teamthree.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
@Service
public class SecurityServiceImpl implements SecurityService{
	@Autowired
	private AuthenticationManager authManager;

	@Override
	public String findLoggedInUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void autologin(String username, String password) {
		// TODO Auto-generated method stub
		
	}
	
	
	


}
