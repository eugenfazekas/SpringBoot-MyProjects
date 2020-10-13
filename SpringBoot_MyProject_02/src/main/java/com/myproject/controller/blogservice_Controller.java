package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.myproject.service.BlogService;

@Controller
public class blogservice_Controller {

	
	private BlogService blogService;
	private Gson gson;
	
	@Autowired
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	
	@Autowired
	public blogservice_Controller(Gson gson) {
		this.gson = gson;
	}

	@GetMapping("menu/blog")
	public String blog (Model model) {
		
		String blogs_json = gson.toJson(blogService.findBlogs());
		model.addAttribute("blogs_json",blogs_json);
		return "menu/blog";
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
