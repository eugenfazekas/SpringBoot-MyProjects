package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.myproject.entity.User;
import com.myproject.service.UserService;

@Controller
public class UserController {
	
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "user/registration";
	}
	
	@PostMapping("/reg")
	public String reg(@ModelAttribute User user) {
		userService.registerUser(user);
			return "main/index";
	}
}
