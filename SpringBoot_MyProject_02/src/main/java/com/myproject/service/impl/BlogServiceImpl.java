package com.myproject.service.impl;

import java.text.SimpleDateFormat;
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

        String pattern = "yyyy.MM.dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
		BlogEntity newBlog = new BlogEntity();
		newBlog.setTitle(title);
		newBlog.setBlog(blog);
		newBlog.setPosted(simpleDateFormat.format(new Date()));
		blogRepository.insertBlog(newBlog);
	}

	@Override
	public List<BlogEntity> findBlogs() {
		
		return blogRepository.findBlogs();
	}

	@Override
	public void deleteBlog(String delete) {
	
		blogRepository.deleteBlog(delete);
	}
}
