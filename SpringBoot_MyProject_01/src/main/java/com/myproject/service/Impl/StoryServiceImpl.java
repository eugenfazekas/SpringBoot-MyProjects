package com.myproject.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.entity.Story;
import com.myproject.repository.Impl.StoryRepositoryImpl;
import com.myproject.service.StoryService;

@Service
public class StoryServiceImpl implements StoryService {

	private StoryRepositoryImpl storyRepositoryImpl;

	private String title;
	
	public StoryServiceImpl(StoryRepositoryImpl storyRepositoryImpl) {
		this.storyRepositoryImpl = storyRepositoryImpl;
	}

	@Override
	public void save(Story story) {
		story.setCreated(new Date());
		storyRepositoryImpl.save(story);
	}

	@Override
	public List<Story> findByOrderByIdDesc() {
		
		return storyRepositoryImpl.findByOrderByIdDesc();
	}

	@Override
	public Story findByTitle(String title) {
		
		return storyRepositoryImpl.findByTitle(title);
	}

	@Override
	public void deleteByTitle(String title) {
		
		storyRepositoryImpl.deleteByTitle(title);
	}

	@Override
	public Story StoryForIndex() {
		Story story = new Story();
	
		if(getTitle() != null)
			try {
			 Story storyFromRepo = storyRepositoryImpl.findByTitle(getTitle());
			story = storyFromRepo;
			}catch (Exception e) {}
		return story;
	}
	
	@Override
	public Integer storyExist(String title) {
		
		return storyRepositoryImpl.storyExist(title);
		
	}
	
	@Override
	public String getTitle() {
		System.out.println("Get: "+title);
		return title;
	}
	
	@Override
	public void setTitle(String title) {
		this.title = title;
		System.out.println("Set: "+title);
	}

	

}
