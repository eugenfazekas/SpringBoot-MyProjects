package com.myproject.service;

import java.util.List;

import com.myproject.entity.Story;

public interface StoryService {

	void save(Story story);
	
	List<Story> findByOrderByIdDesc();
	
	Story findByTitle(String title);
	
	void deleteByTitle(String title);
		
	Story StoryForIndex();
	
	void setTitle(String title);
	
}
