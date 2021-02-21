package com.myproject.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.model.User;
import com.myproject.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("user")
public class UserController {
	
	private UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "userExistCheck", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean userExistCheck(@RequestParam String email) {
		
		return userService.userExistCheck(email);
	}
	
	@RequestMapping(value = "registerUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User registerUser(@RequestBody User user) {

		userService.registerUser(user);
	    return user;
	}
	
	@RequestMapping(value = "findUserByEmail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User findUserByEmail(@RequestParam String email) {

		return userService.findUserByEmail(email);
		
	}
}
