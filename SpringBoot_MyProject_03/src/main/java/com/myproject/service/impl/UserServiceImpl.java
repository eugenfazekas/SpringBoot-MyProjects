package com.myproject.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
	public void registerUser(User user) {
    
		UUID uuid = UUID.randomUUID();
		
		user.setId(uuid.toString());
	    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	    user.setFullName();
	    user.setDate_registered(getDate());
	    user.setActive(true);
		List<String> authority = new ArrayList<String>();
		authority.add("user");
		user.setAuthorities(authority);
		userRepository.registerUser(user);
		createUserDirPath(uuid.toString());
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

	@Override
	public String getDate() {
		
		String pattern = "yyyy.MM.dd HH:mm:ss";
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	    
		return simpleDateFormat.format(new Date());
	}

	@Override
	public void createUserDirPath(String userId) {
		    
	    Path finaelPath = Paths.get("src/main/resources/static/user/"+ userId);
	    try {
			Files.createDirectories(finaelPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    log.debug("Directory is created!");
		
	}
}
