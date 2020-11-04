package com.teamthree.ecommerce.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
@Service
public class SecurityServiceImpl implements SecurityService{
	
	@Autowired
	private AuthenticationManager authenicationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	private final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

	@Override
	public String findLoggedInUsername() {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
		
		if(userDetails instanceof UserDetails){
			return ((UserDetails)userDetails).getUsername();
		}
		return null;
	}

	@Override
	public void autologin(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		
		authenicationManager.authenticate(usernamePasswordAuthenticationToken);

		if(usernamePasswordAuthenticationToken.isAuthenticated()){
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			logger.debug(String.format("Autologin for %s is successful!", username));
		}

	}
	
	
	


}