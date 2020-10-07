package com.myproject.service;

import java.util.List;

import com.myproject.entity.BlogEntity;

public interface BlogService {

	void insertBlog(String title, String blog);
	
	public List<BlogEntity> findBlogs();
	
	public List<BlogEntity> findByTiltleIgnoreCaseOrContentOrderByIdDesc(String inputSearch);
	
	public void deleteBlog(String title);
}
