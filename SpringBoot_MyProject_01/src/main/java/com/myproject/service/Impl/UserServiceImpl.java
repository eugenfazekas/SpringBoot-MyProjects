package com.myproject.service.Impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.myproject.entity.User;
import com.myproject.repository.Impl.UserRepositoryImpl;
import com.myproject.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private UserRepositoryImpl userRepositoryImpl;

	@Autowired
	public UserServiceImpl(UserRepositoryImpl userRepositoryImpl) {
		this.userRepositoryImpl = userRepositoryImpl;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepositoryImpl.findByEmail(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
			}	log.debug(user.toString());
		return new UserDetailsImpl(user);
	}
		
	@Override
	public void registerUser (User user) {
		
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setActivation(UUID.randomUUID().toString());
		user.setEnabled(true);
		user.setAuthority("USER");
		userRepositoryImpl.save(user);
		log.debug(user.toString());
	}
}


