package com.myproject.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.imageio.ImageIO;

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
	 public String singleFileUpload(@RequestParam("fileInput") MultipartFile file,Model model) throws Exception {
			
	 if (file.isEmpty()) {
		 model.addAttribute("messageError", "Please select a file to upload");
		 System.out.println("Controller file empty:"+file.getSize());
	 		return "/menu/upload";
	 }
	 	try {
		  		imageService.saveFile(file);		  		
	 	} catch (IOException e) {
	 			e.printStackTrace();
	 	}
	 			 	
	 		return "redirect:/menu/upload";
	 }
	
	@PostMapping("/uploadImage2") 
	 public String singleFileUpload2(@RequestParam("fileOutput") MultipartFile file,Model model) throws Exception {
		
		System.out.println(file.getOriginalFilename());
			  UUID uuid = UUID.randomUUID();
		      InputStream bis = file.getInputStream();
		      BufferedImage bImage2 = ImageIO.read(bis);
		      ImageIO.write(bImage2, "png", new File("src/main/resources/static/img/upload/"+ uuid+".jpg") );
		      System.out.println("image created");
	 			 	
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
