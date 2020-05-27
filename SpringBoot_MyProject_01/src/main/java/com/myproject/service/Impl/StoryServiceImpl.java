package com.myproject.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.entity.Story;
import com.myproject.repository.StoryRepository;
import com.myproject.service.StoryService;

@Service
public class StoryServiceImpl implements StoryService {

	private StoryRepository storyRepository;

	@Autowired
	public StoryServiceImpl(StoryRepository storyRepository) {
		this.storyRepository = storyRepository;
	}

	@Override
	public void save(Story story) {
		story.setCreated(new Date());
		storyRepository.save(story);
	}

	@Override
	public List<Story> findByOrderByIdDesc() {
		
		return storyRepository.findByOrderByIdDesc();
	}

	
	@Override
	public void deleteByTitle(String title) {
		
		storyRepository.deleteByTitle(title);
	}

	@Override
	public Story StoryForIndex() {
		Story story = new Story();
		if(storyRepository.activeStoryExsit()>0)
		story = storyRepository.findByActivation();
		return story;
	}
	
	@Override
	public Integer storyExist(String title) {
		
		return storyRepository.storyExist(title);
			}

	@Override
	public void setStoryActive(String title) {
		
		storyRepository.setStoryActive(title);
		
	}

	@Override
	public void setStoryInactive() {
		
		storyRepository.setStoryInactive();
	}

	@Override
	public Integer activeStoryExsit() {
		
		return storyRepository.activeStoryExsit();
	}
	
}
