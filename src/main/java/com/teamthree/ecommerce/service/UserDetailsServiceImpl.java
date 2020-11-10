package com.teamthree.ecommerce.service;

import java.util.HashSet;
import java.util.Set;

import com.teamthree.ecommerce.model.Role;
import com.teamthree.ecommerce.model.User;
import com.teamthree.ecommerce.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    

    @Override
    @Transactional(readOnly= true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Role role = new Role();
        User user = userRepository.findByUsername(username);

        Set<Role> roles = new HashSet<>();
        role.setName("ROLE_USER");
        roles.add(role);
        user.setRoles(roles);
        

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        // for (Role role : user.getRoles()){
        //     grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        // }
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
