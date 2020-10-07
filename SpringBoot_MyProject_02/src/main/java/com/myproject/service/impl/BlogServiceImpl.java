package com.myproject.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.entity.BlogEntity;
import com.myproject.repository.BlogRepository;
import com.myproject.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService{

	private BlogRepository blogRepository;
	
	public BlogServiceImpl(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}

	@Override
	public void insertBlog(String title, String blog) {
		
		BlogEntity newBlog = new BlogEntity();
		newBlog.setTitle(title);
		newBlog.setBlog(blog);
		newBlog.setPosted(new Date());
		blogRepository.insertBlog(newBlog);
	}

	@Override
	public List<BlogEntity> findBlogs() {
		
		return blogRepository.findBlogs();
	}

	@Override
	public List<BlogEntity> findByTiltleIgnoreCaseOrContentOrderByIdDesc(String inputSearch) {

		return null;
	}

	@Override
	public void deleteBlog(String delete) {
	
		blogRepository.deleteBlog(delete);
	}

}
