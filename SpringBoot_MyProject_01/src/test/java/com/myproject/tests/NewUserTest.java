package com.myproject.tests;


import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myproject.entity.RegistrationForm;
import com.myproject.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NewUserTest {
	
private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	Locale locale = new Locale("en");

	@Test
	public void userRegistrationTest() {

		userService.registerUser(new RegistrationForm("Eugen"," Fazekas","John@doe.hu","password"),locale);
		
	}

}
