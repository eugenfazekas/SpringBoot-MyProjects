package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.entity.ServiceEntity;
import com.myproject.service.PackageService;

@Controller
public class service_Controller {
	
	private String checkNull (String input_check) {
		String outputcheck = "n";
		if(input_check != null) {
			outputcheck = input_check;
		}  return outputcheck;
	}

	private PackageService packageService;
	
	@Autowired
	public void setPackageService(PackageService packageService) {
		this.packageService = packageService;
	}
	
	@RequestMapping("/menu/services1")
	public String package_search (Model model ,@RequestParam String html_page, String html_element, String service_db, String search, String multilanguage, String animation, String auth, String newsletter, String height) {

		ServiceEntity serviceEntity = new ServiceEntity(html_page,html_element,service_db,search,multilanguage,animation,auth,newsletter,height);
				  
		model.addAttribute("packages", packageService.findPackagesBySpec(html_page, html_element, service_db, checkNull(search), checkNull(multilanguage), checkNull(animation), checkNull(auth), checkNull(newsletter))); 
		model.addAttribute("serviceEntity", serviceEntity); 
		
			return "/menu/services";
	}
	


}
