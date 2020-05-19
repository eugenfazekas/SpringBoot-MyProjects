package com.myproject.repository.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.myproject.entity.User;
import com.myproject.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public User findByEmail(String email) {
		
		return null;
	}

	@Override
	public void save(User user) {
		
		final String sql = "INSERT INTO users (firstname,lastname,email,password,activation,enabled,authority) VALUES (?,?,?,?,?,?,?)";
		jdbc.update(sql,user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),
				user.getActivation(),user.getEnabled().toString(),user.getAuthority());
	}

}
