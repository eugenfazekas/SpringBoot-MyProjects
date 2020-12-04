package com.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	 public String singleFileUpload2(@RequestParam("fileInput") MultipartFile file,Model model) throws Exception {
		
		imageService.saveFile(file);

	 	return "/menu/upload";
	 }
	
	@PostMapping("/findImages") 
	public  String findImages(@RequestParam String search, Model model) throws Exception {
		
		model.addAttribute("images",imageService.findImagesByName(search));
		
		return"/menu/upload";
	}
	
	@PostMapping("/imageDelete")
	public String blogreg (@RequestParam String id) {
		imageService.deleteImage(id);
		
		return "redirect:/menu/upload";
	}

}
