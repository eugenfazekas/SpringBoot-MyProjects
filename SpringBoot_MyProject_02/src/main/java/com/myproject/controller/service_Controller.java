package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.service.PackageService;

@Controller
public class service_Controller {

	private PackageService packageService;
	
	@Autowired
	public void setPackageService(PackageService packageService) {
		this.packageService = packageService;
	}
	
	@RequestMapping("/menu/services1")
	public String package_search (Model model) {

		
		
			return "/menu/services";
	}
	


}
