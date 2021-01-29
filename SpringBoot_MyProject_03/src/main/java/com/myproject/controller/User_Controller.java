package com.myproject.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.User;
import com.myproject.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("user")
public class User_Controller {
	
	private UserService userService;

	public User_Controller(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("login")
	public String user_login(@RequestParam String userName, String password) {
		System.out.println(userName+ " " + password);
		return "ok";
	}
	
	@PostMapping("createUser")
	@ResponseBody
	public User registerUser(@RequestBody User user) {

		userService.registerUser(user);
	    return user;
	}
}
