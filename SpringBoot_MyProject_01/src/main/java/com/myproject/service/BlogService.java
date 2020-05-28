package com.myproject.service;

import java.util.List;

import com.myproject.entity.Blog;

public interface BlogService {
	
	void save(Blog blog);
	
	void deleteBlog(String title);
	
	String bloggerNameCreator();
	
	List<Blog> findByOrderByIdDesc();

	List<Blog> findByTiltleIgnoreCaseOrContentOrderByIdDesc(String search);

}
