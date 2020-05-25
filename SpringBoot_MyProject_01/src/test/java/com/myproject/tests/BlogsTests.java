package com.myproject.tests;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.myproject.entity.Blog;
import com.myproject.service.BlogService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogsTests {
	
	@MockBean
	private BlogService blogService;

	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	
	@Test
	public void blogSaveTest() {
		
		when(blogService.bloggerNameCreator()).thenReturn("teszt");
		blogService.save(new Blog("Teszt Cim","Teszt tartalom"));
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
