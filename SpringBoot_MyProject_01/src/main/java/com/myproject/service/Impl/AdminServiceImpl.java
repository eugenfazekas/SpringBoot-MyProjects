package com.myproject.service.Impl;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.entity.RegistrationForm;
import com.myproject.entity.User;
import com.myproject.repository.UserRepository;
import com.myproject.service.AdminService;
import com.myproject.service.EmailService;

@Service
public class AdminServiceImpl implements AdminService {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private UserRepository userRepository;
	private EmailService emailService;
		
	@Autowired
	public AdminServiceImpl(UserRepository userRepository, EmailService emailService) {
		this.userRepository = userRepository;
		this.emailService = emailService;
	}

	@Override
	public void AdminInit() {
		User user = new User();
		user.setFullName("GonaDeletedFullName");
		user.setEmail("TemporalyEmailfiled");
		user.setPassword(new BCryptPasswordEncoder().encode("GonaDeletedPassword"));
		user.setActivation(UUID.randomUUID().toString());
		user.setEnabled(false);
		user.setAuthority("0");
		emailService.sendAdminCode(user.getActivation());
		userRepository.save(user);
		log.debug(user.toString());
		
	}

	@Override
	public Integer findByActivation(String activationcode) {
		
		return userRepository.activationExist(activationcode);

	}
	
	@Override
	public Integer adminExist(String email, String fullname) {
		
		return userRepository.userExist(email,fullname);
	}

	@Override
	public void registerAdmin(RegistrationForm adminToRegister) {
		User user = new User();
		user.setFullName(adminToRegister.getFirstName()+" " +adminToRegister.getLastName());
		user.setPassword(new BCryptPasswordEncoder().encode(adminToRegister.getPassword()));
		user.setEmail(adminToRegister.getEmail());
		user.setActivation("");
		user.setEnabled(true);
		user.setAuthority("ADMIN");
		userRepository.save(user);
		log.debug("New Admin: "+user.toString());
		
	}

	@Override
	public void deleteAdminByActication(String code) {
		
		userRepository.deleteAdminActivation(code);
		
	}



	

	





	
}
