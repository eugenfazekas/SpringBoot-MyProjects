package com.myproject.service.impl;

import org.springframework.stereotype.Service;

import com.myproject.model.User;
import com.myproject.repository.UserRepository;
import com.myproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;

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

		User outUser = new User();
		outUser = inUser;
		outUser.setFullName();
		outUser.setActive(false);
		userRepository.registerUser(outUser);
	}
}
