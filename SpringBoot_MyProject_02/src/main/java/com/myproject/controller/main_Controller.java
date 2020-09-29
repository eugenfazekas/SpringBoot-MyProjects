package com.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class main_Controller {
	
	@GetMapping("/")
	public String index () {
		return "menu/index";
	}
	
	@GetMapping("index")
	public String index2 () {
		return "menu/index";
	}
	
	@GetMapping("test")
	public String test () {
		return "fragment/fragment";
	}
	
	@GetMapping("menu/contact")
	public String contact () {
		return "menu/contact";
	}
	
	@GetMapping("menu/logo")
	public String logo () {
		return "menu/logo";
	}
	
	@GetMapping("menu/blog")
	public String blog () {
		return "menu/blog";
	}
	
	@GetMapping("menu/webshop")
	public String webshop () {
		return "menu/webshop";
	}
	
//	@GetMapping("/google99ae87171024d25b")
//	public String googleCheck () {
//		return "menu/google99ae87171024d25b";
//	}
}
