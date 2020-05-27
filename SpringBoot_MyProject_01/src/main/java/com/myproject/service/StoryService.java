package com.myproject.service;

import java.util.List;

import com.myproject.entity.Story;

public interface StoryService {

	void save(Story story);
	
	List<Story> findByOrderByIdDesc();
	
	void deleteByTitle(String title);
		
	Story StoryForIndex();
	
	void setStoryActive(String title);
	
	void setStoryInactive();
	
	Integer storyExist(String title);
	
	Integer activeStoryExsit();
	
}
