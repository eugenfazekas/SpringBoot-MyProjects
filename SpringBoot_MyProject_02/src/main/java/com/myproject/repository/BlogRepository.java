package com.myproject.repository;

import java.util.List;

import com.myproject.entity.BlogEntity;

public interface BlogRepository {
	
	void insertBlog(BlogEntity blog);

	List<BlogEntity> findBlogs();
	
	public void deleteBlog(String title);

}
