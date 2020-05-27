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

	private String title;
	
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
	public Story findByTitle(String title) {
		
		return storyRepository.findByTitle(title);
	}

	@Override
	public void deleteByTitle(String title) {
		
		storyRepository.deleteByTitle(title);
	}

	@Override
	public Story StoryForIndex() {
		Story story = new Story();
		if(getTitle() != null)
			try {
			 Story storyFromRepo = storyRepository.findByTitle(getTitle());
			story = storyFromRepo;
			}catch (Exception e) {}
		return story;
	}
	
	@Override
	public Integer storyExist(String title) {
		
		return storyRepository.storyExist(title);
			}
	
	@Override
	public String getTitle() {
		return title;
	}
	
	@Override
	public void setTitle(String title) {
		this.title = title;
		}
}
