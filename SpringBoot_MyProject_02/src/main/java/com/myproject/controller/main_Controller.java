package com.myproject.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.entity.ServiceEntity;
import com.myproject.service.PackageService;
import com.myproject.service.ImageService;

@Controller
@RequestMapping("/")
public class main_Controller {
	
	private PackageService packageService;
	private ImageService saveImageService;
	private int counter;
	
	@Autowired
	public main_Controller(PackageService packageService, ImageService imageService) {
		this.packageService = packageService;
		this.saveImageService = imageService;
	}

	@GetMapping("/")
	public String index (Model model,HttpServletRequest request, HttpServletResponse response, Object handler) {

	        String ipAddress = request.getHeader("X-Forward-For");
	 
	        if(ipAddress== null){
	 
	            ipAddress = request.getRemoteAddr();
	            
	            counter++;
	 
	        System.out.println("IpAddress: "+ipAddress+",\nVisitators: "+ counter+" Date: "+ new Date());
	        }
		
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
	
	@GetMapping("menu/upload")
	public String upload (Model model) {
				
		model.addAttribute("images", saveImageService.findAllImages());
		
		return "menu/upload";
	}
	
	@PostMapping("/uploadImage") 
	 public String singleFileUpload(@RequestParam("file") MultipartFile file,Model model) throws Exception {
			
	 if (file.isEmpty()) {
		 model.addAttribute("messageError", "Please select a file to upload");
	 		return "redirect:/";
	 }
	 	try {
		  		saveImageService.saveFile(file);
		  		model.addAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
				model.addAttribute("image", saveImageService.showImage(file.getOriginalFilename()));
					  		
	 	} catch (IOException e) {
	 			e.printStackTrace();
	 	}
	 			 	
	 		return "redirect:/menu/upload";
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
