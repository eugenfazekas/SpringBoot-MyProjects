package com.myproject.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myproject.entity.RegistrationForm;
import com.myproject.service.AdminService;

@Controller
public class AdminController {

	private AdminService adminService;
		
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(path = "/index/getadminkey", method = RequestMethod.GET)
	public String adminKeyGenerator() {
		adminService.AdminInit();
		return "error/detailederror";
	}

	@RequestMapping(path = "/index/admincheck/{code}", method = RequestMethod.GET)
    public String codeCheckAdmin(@PathVariable("code") String code, HttpServletResponse response,Model model) {
		if(adminService.findByActivation(code) > 0) {
       	model.addAttribute("admin", new RegistrationForm());
       		adminService.deleteAdminByActication(code);
 		return "admin/adminregistration";
		} 
			return "main/index";
 }

	@RequestMapping(value = "/index/adminreg", method = RequestMethod.POST)
	public String adminreg(@Valid @ModelAttribute("admin") RegistrationForm admin, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "admin/adminregistration";
		}
		else if(adminService.adminExist(admin.getEmail(), admin.getFirstName()+" "+admin.getLastName()) > 0){
			model.addAttribute("exist", " ");
			return "admin/adminregistration";
		}
		else {
			model.addAttribute("message"," ");
			adminService.registerAdmin(admin);
		}
		return "forward:/";
	}
	
}
