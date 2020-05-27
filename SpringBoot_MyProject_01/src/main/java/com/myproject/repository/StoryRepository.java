package com.myproject.repository;

import java.util.List;

import com.myproject.entity.Story;

public interface StoryRepository {
	
	void save(Story story);
	
	void setStoryActive(String title);
	
	void setStoryInactive();
	
	List<Story> findByOrderByIdDesc();
	
	Story findByActivation();
	
	void deleteByTitle(String title);
	
	Integer storyExist(String title);
	
	Integer activeStoryExsit();

}
