package com.myproject.repository;

import java.util.List;

import com.myproject.entity.BlogEntity;

public interface BlogRepository {
	
	void insertBlog(BlogEntity blog);

	List<BlogEntity> findBlogs();
	
	public List<BlogEntity> findByTiltleIgnoreCaseOrContentOrderByIdDesc(String inputSearch);
	
	public void deleteBlog(String title);

}
