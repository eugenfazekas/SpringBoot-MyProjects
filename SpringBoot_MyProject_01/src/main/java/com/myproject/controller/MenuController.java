package com.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.entity.User;

@Controller
public class mainController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("user", new User());
		return "main/index";
	}
	
	@RequestMapping("/description")
	public String desription() {
		return"main/description";
	}
}
