package com.myproject.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myproject.entity.Blog;
import com.myproject.service.BlogService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogsTests {

	private BlogService blogService;

	@Autowired
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	
	@Test
	public void blogSaveTest() {
	blogService.save(new Blog("JUnit Cim","JUnit Tartalom"));
	}
	
	@Test
	public void blogArrayTest() {
		blogService.findByOrderByIdDesc();
	}
	
	@Test
	public void blogSearchTest() {
		blogService.findByTiltleIgnoreCaseOrContentOrderByIdDesc("john");
	}
}
