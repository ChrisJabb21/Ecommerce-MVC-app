package com.teamthree.ecommerce.service;

import java.util.HashSet;
import java.util.List;

import com.teamthree.ecommerce.model.User;
import com.teamthree.ecommerce.repository.RoleRepository;
import com.teamthree.ecommerce.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    //

    @Override
    public User getUserById(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
	}

	@Override
	public void addUser(User user) {
        userRepository.save(user);
	}

	@Override
	public List<User> listUsers() {
        
		return (List<User>) userRepository.findAll();
	}
}
