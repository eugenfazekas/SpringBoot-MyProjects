package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.entity.ServiceEntity;
import com.myproject.service.PackageService;

@Controller
@RequestMapping("/")
public class main_Controller {
	
	private PackageService packageService;
	
	@Autowired
	public void setPackageService(PackageService packageService) {
		this.packageService = packageService;
	}


	@GetMapping("/")
	public String index (Model model) {
		
		model.addAttribute("packages", packageService.findPackages());
		
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
	
	
	
	@GetMapping("menu/webshop")
	public String webshop () {
		return "menu/webshop";
	}
	
	@PostMapping("/")
	public String packages (Model model) {
		
		model.addAttribute("packages", packageService.findPackages());
		
		return "menu/index";
	}
	
	@GetMapping("menu/services")
	public String services (Model model) {
		
		ServiceEntity serviceEntity = new ServiceEntity("packages_page_htmlone","packages_page_elementsone","n","","","","","","0");
		model.addAttribute("packages", packageService.findPackagesBySpec("packages_page_htmlone","packages_page_elementsone","n","n","n","n","n","n")); 
		model.addAttribute("serviceEntity", serviceEntity);
		return "menu/services";
	}
	
//	@GetMapping("/google99ae87171024d25b")
//	public String googleCheck () {
//		return "menu/google99ae87171024d25b";
//	}
}
