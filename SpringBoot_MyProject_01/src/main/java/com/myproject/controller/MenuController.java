package com.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuController {
			
	@RequestMapping("/user/description")
	public String desription() {
		return"main/description";
	}
	@RequestMapping("/login")
	public String login() {
		return "main/index";
	}
	
	@RequestMapping("/user/videos")
	public String videos() {
		return"main/videos";
	}
	@RequestMapping("/user/contact")
	public String contact() {
		
		return"main/contact";
	}
}

