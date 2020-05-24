package com.myproject.service;

import java.util.Locale;

import com.myproject.entity.RegistrationForm;
import com.myproject.entity.User;

public interface UserService {

	void registerUser(RegistrationForm userToRegister,Locale locale);

	Integer userExist(String email,String fullname);
	
	String userActivation(String activationCode);

}
