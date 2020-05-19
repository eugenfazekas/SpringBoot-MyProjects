package com.myproject.repository;

import com.myproject.entity.User;

public interface UserRepository {

	User findByEmail(String email);
	
	void save(User user);

}
