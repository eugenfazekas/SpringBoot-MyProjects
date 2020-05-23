package com.myproject.service;

import com.myproject.entity.RegistrationForm;
import com.myproject.entity.User;

public interface UserService {

	void registerUser(RegistrationForm userToRegister);

	String ifUserExsitByEmail(String email);

}
