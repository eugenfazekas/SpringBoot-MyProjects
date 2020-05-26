package com.myproject.repository;

import java.util.List;

import com.myproject.entity.Story;

public interface StoryRepository {
	
	void save(Story story);
	
	List<Story> findByOrderByIdDesc();
	
	Story findByTitle(String title);
	
	void deleteByTitle(String title);
	
	Integer storyExist(String title);

}
