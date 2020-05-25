package com.myproject.repository;

import java.util.List;
import com.myproject.entity.Blog;

public interface BlogRepository {

	void save(Blog blog);
			
	List<Blog> findByOrderByIdDesc();
	
	List<Blog> findByTiltleIgnoreCaseOrContentOrderByIdDesc(String search);
}
