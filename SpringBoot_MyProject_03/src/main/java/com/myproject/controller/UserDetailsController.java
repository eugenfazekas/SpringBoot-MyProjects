package com.myproject.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.model.User;
import com.myproject.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("userDetails")
public class UserDetailsController {
	
	private UserService userService;

	public UserDetailsController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "findUserByEmail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User findUserByEmail(@RequestParam String email) {

		return userService.findUserByEmail(email);
		
	}
	
	@RequestMapping(value = "updateUser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User user) {

		return userService.updateUser(user);

	}
	
	@RequestMapping(value = "saveProfileImage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveProfileImage(@RequestParam MultipartFile fileInput) {

		userService.uploadProfilePhoto(fileInput);
		return "Image saved";

	}
	
	@RequestMapping(value = "deleteProfileImage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String deleteProfileImage(@RequestParam String id, String imageName, String imageNameActive) {
		
		userService.deleteProfilePhoto(id, imageName, Boolean.valueOf(imageNameActive));
		return "Image deleted";
	}
	
	@RequestMapping(value = "setActiveProfilePhoto", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String setActiveProfilePhoto(@RequestParam String id, String imageName) {

		 userService.setActiveProfilePhoto(id, imageName);
		 return imageName;

	}
}
