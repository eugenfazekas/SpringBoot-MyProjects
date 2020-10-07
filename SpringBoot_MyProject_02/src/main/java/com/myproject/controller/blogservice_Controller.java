package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.service.BlogService;

@Controller
public class blogservice_Controller {

	private BlogService blogService;
	
	
	@Autowired
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}


	@PostMapping("/blogreg")
	public String blogreg (@RequestParam String title, String blog) {
		
		blogService.insertBlog(title,blog);
		
		return "redirect:/menu/blog";
	}
	
	@PostMapping("/blogdelete")
	public String blogreg (@RequestParam String delete) {
		
		blogService.deleteBlog(delete);
		
		return "redirect:/menu/blog";
	}
}
