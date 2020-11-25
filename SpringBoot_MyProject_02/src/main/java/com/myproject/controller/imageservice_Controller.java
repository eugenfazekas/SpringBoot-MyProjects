package com.myproject.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.service.ImageService;

@Controller
public class imageservice_Controller {
	
	private ImageService imageService;
	
		
	public imageservice_Controller(ImageService imageService) {
		this.imageService = imageService;
	}

	@PostMapping("/uploadImage") 
	 public String singleFileUpload(@RequestParam("file") MultipartFile file,Model model) throws Exception {
			
	 if (file.isEmpty()) {
		 model.addAttribute("messageError", "Please select a file to upload");
	 		return "redirect:/";
	 }
	 	try {
		  		imageService.saveFile(file);		  		
	 	} catch (IOException e) {
	 			e.printStackTrace();
	 	}
	 			 	
	 		return "redirect:/menu/upload";
	 }
	
	@PostMapping("/findImages") 
	public  String findImages(@RequestParam String search, Model model) throws Exception {
		
		model.addAttribute("images",imageService.findImagesByName(search));
		
		return"/menu/upload";
	}
	
	@PostMapping("/imageDelete")
	public String blogreg (@RequestParam String name) {
		
		imageService.deleteImage(name);
		
		return "redirect:/menu/upload";
	}

}
