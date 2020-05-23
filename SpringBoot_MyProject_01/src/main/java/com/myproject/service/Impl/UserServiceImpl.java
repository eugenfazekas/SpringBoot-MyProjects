package com.myproject.service.Impl;

import java.util.Locale;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.entity.RegistrationForm;
import com.myproject.entity.User;
import com.myproject.repository.Impl.UserRepositoryImpl;
import com.myproject.service.EmailService;
import com.myproject.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private UserRepositoryImpl userRepositoryImpl;
	private EmailService emailService;

	@Autowired
	public UserServiceImpl(UserRepositoryImpl userRepositoryImpl, EmailService emailService) {
		this.userRepositoryImpl = userRepositoryImpl;
		this.emailService = emailService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepositoryImpl.findByFullName(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
			}	
		log.debug("Authenticating: "+user.toString());
		return new UserDetailsImpl(user);
	}
		
	

	@Override
	public void registerUser (RegistrationForm userToTegister,Locale locale) {
		User user = new User();
		user.setFullName(userToTegister.getFirstName()+" " +userToTegister.getLastName());
		user.setPassword(new BCryptPasswordEncoder().encode(userToTegister.getPassword()));
		user.setEmail(userToTegister.getEmail());
		user.setActivation(UUID.randomUUID().toString());
		user.setEnabled(false);
		user.setAuthority("USER");
		userRepositoryImpl.save(user);
		emailService.sendUserMessage(user, userToTegister, locale);
		log.debug("New User: "+user.toString());
	}

	@Override
	public Integer emailExist(String email)  {
			
		return userRepositoryImpl.emailExist(email);
	}

	@Override
	public String userActivation(String activationCode) {
		
		return userRepositoryImpl.findByActivation(activationCode);
	}

	

}


