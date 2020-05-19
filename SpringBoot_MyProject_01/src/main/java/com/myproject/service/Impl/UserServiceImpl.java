package com.myproject.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.entity.User;
import com.myproject.repository.Impl.UserRepositoryImpl;
import com.myproject.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private UserRepositoryImpl userRepositoryImpl;

	@Autowired
	public UserServiceImpl(UserRepositoryImpl userRepositoryImpl) {
		this.userRepositoryImpl = userRepositoryImpl;
	}

	@Override
	public void registration(User user) {
	
	}

}
