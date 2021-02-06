package com.myproject.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.model.User;
import com.myproject.repository.UserRepository;
import com.myproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void createCollectionUsers() {

		userRepository.createCollectionUsers();
	}

	@Override
	public void dropCollectionUsers() {
		
		userRepository.dropCollectionUsers();
	}

	@Override
	public void registerUser(User inUser) {
		
		String pattern = "yyyy.MM.dd HH:mm:ss";
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	    
		User outUser = inUser;
		outUser.setPassword(new BCryptPasswordEncoder().encode(inUser.getPassword()));
		outUser.setFullName();
		outUser.setDate_registered(simpleDateFormat.format(new Date()));
		outUser.setActive(true);
		List<String> authority = new ArrayList<String>();
		authority.add("user");
		outUser.setAuthorities(authority);
		userRepository.registerUser(outUser);
	}

	@Override
	public boolean userExistCheck(String email) {
		
		return userRepository.userExistCheck(email);
	}

	@Override
	public User findUserByEmail(String email) {
		
		User user = new User();
		try {
			user = userRepository.findUserByEmail(email);
		} catch (Exception e) {
			log.info("User Not Found!");
		}
		return user;
	}
}
