package com.myproject.controller;

import java.util.Locale;

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
import com.myproject.service.UserService;

@Controller
public class UserController {
			
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/registration",method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("user", new RegistrationForm());
		return "user/registration";
	}

	@RequestMapping(value = "/reg", method = RequestMethod.POST)
	public String reg(@Valid @ModelAttribute("user") RegistrationForm user, BindingResult result,Model model,Locale locale) {
		if(result.hasErrors()) {
			return "user/registration";
		}
		else if(userService.userExist(user.getEmail(), user.getFirstName()+" "+user.getLastName()) > 0){
			model.addAttribute("exist", " ");
			return "user/registration";
		}
		else {
			model.addAttribute("message"," ");
			userService.registerUser(user,locale);
		}
		return "forward:/";
	}
	
	 @RequestMapping(path = "/activation/{code}", method = RequestMethod.GET)
	    public String activation(@PathVariable("code") String code, HttpServletResponse response,Model model) {
	    	model.addAttribute("activation", userService.userActivation(code));
	 		return "forward:/";
	 }
	

}
