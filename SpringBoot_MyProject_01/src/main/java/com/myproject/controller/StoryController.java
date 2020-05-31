package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.myproject.entity.Story;
import com.myproject.service.StoryService;

@Controller
public class StoryController {
	
	private final String STORY_ATTRIBUTE= "story";
	
	private StoryService storyService;
	
	@Autowired
	 public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute(STORY_ATTRIBUTE, storyService.StoryForIndex());
		return "main/index";
	}

	@RequestMapping("admin/addstory")
	public String addstory(Model model) {
		model.addAttribute(STORY_ATTRIBUTE, new Story());
		return "admin/addstory";
	}

	 @PostMapping("/admin/storyreg")
	 public String indexreg(@ModelAttribute(STORY_ATTRIBUTE) Story story, Model model){
		 if(storyService.storyExist(story.getTitle()) > 0){
				model.addAttribute("exist", " ");
				return "admin/addstory";
			}else {
		 storyService.save(story);
			}
		 return "forward:/admin/stories";
	 }
	
	 @RequestMapping("admin/stories")
	 public String stories(Model model) {
		 model.addAttribute("stories", storyService.findByOrderByIdDesc());
		 	return "admin/stories";
				}
	 
	 
	 @RequestMapping("admin/setstory")
		public String story (Model model ,@RequestParam(defaultValue="")String setStory ) {
			if(storyService.activeStoryExsit()>0 && storyService.storyExist(setStory)>0) {
				storyService.setStoryInactive();
			}
			if(storyService.storyExist(setStory)>0) {
				storyService.setStoryActive(setStory);
			}
				return "forward:/admin/stories";
		}
	 
	 @RequestMapping("admin/storydelete")
		public String storydelete (Model model ,@RequestParam(defaultValue="")String storydelete ) {
			 storyService.deleteByTitle(storydelete);
				return "forward:/admin/stories";
		}
	
}
