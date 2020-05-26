package com.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
			
	@RequestMapping("/description")
	public String desription() {
		return"main/description";
	}
	@RequestMapping("/login")
	public String login() {
		return "main/index";
	}
}
