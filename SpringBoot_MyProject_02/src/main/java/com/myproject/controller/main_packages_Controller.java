package com.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("menu/packages")
public class main_packages_Controller {
	
	@GetMapping("/basic")
	public String basic () {
		return "menu/packages/basic";
	}
	
	@GetMapping("/dynamic")
	public String dynamic () {
		return "menu/packages/dynamic";
	}
	
	@GetMapping("/start")
	public String start () {
		return "menu/packages/start";
	}
	
	@GetMapping("/premium")
	public String advance () {
		return "menu/packages/premium";
	}

}
