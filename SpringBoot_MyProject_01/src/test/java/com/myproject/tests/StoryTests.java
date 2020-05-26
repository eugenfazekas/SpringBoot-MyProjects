package com.myproject.tests;
import com.myproject.entity.Story;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.myproject.service.StoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoryTests {
	
	private StoryService storyService;

	@Autowired
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
	
	@Test
	public void storySaveTest1() {
			storyService.save(new Story("Test Title1","Test Content1","Test Content2","Test Content3","Test Image1","Test Video1"));
	}
	@Test
	public void storySaveTest2() {
			storyService.save(new Story("Test Title2","Test Content1","Test Content2","Test Content3","",""));
	}

	@Test 
	public void storyListTest() {
		storyService.findByOrderByIdDesc();
	}
	
	@Test 
	public void storyFindByTitleTest() {
		storyService.findByTitle("Story Title");
	}
	
	@Test
	public void storyDeleteTest() {
		storyService.deleteByTitle("Story Title");
	}
	
}
