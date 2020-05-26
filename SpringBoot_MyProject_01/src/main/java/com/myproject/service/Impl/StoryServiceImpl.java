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
		String storytitle = getTitle();
		if(!storytitle.equals(null))
			story = storyRepositoryImpl.findByTitle(storytitle);
		
		return story;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

}
