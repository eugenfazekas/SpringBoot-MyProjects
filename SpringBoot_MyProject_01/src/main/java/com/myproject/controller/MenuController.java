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
	
	@RequestMapping("/videos")
	public String videos() {
		return"main/videos";
	}
	@RequestMapping("/contact")
	public String contact() {
		
		return"main/contact";
	}
}

