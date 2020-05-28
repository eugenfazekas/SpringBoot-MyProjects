package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.entity.Blog;
import com.myproject.entity.RegistrationForm;
import com.myproject.entity.Story;
import com.myproject.service.BlogService;

@Controller
public class BlogController {
	
	private BlogService blogService;
	
	@Autowired
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}

	@RequestMapping(value="/blogs",method = RequestMethod.GET)
	public String mainBlogs(Model model) {
		
		model.addAttribute("blog", new Blog());
		model.addAttribute("delete", new Blog());
		model.addAttribute("blogs", blogService.findByOrderByIdDesc());
		
		return "blog/mainBlogs";
	}
	
	@RequestMapping(value="/blogreg",method = RequestMethod.POST)
	public String regsiterBlog (@ModelAttribute("blog") Blog blog) {
		blogService.save(blog);
		return"redirect:/blogs";
	}
	
	@RequestMapping("/blogsearch")
	public String videos1 (Model model ,@RequestParam(defaultValue="")String search ) {
		model.addAttribute("blogsearch", blogService.findByTiltleIgnoreCaseOrContentOrderByIdDesc(search));
			return "/blog/searchedblogs";
	}
	
	@RequestMapping(value = "/blogdelete", method = RequestMethod.POST)
	private String deleteStudent(@RequestParam String delete){
		blogService.deleteBlog(delete);
		 return "redirect:/blogs";
	 }
}