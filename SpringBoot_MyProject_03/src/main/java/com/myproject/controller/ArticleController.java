package com.myproject.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.model.Article;
import com.myproject.service.ArticleService;
import com.myproject.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("article")
public class ArticleController {
	
	private ArticleService articleService;

	public ArticleController(ArticleService articleService, UserService userService) {
		this.articleService = articleService;
	}

	@RequestMapping(value = "findAllArticles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Article> findCategories() {
	
	
		return articleService.findAllArticles();
	}

	@RequestMapping(value = "saveArticle", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Article saveArticle(@RequestBody Article article ) {
		
		articleService.saveArticle(article);
		
			return article;
	}
	
	@RequestMapping(value = "saveImage", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String saveImage(@RequestParam MultipartFile fileInput ) {
		
		articleService.saveImage(fileInput);
		
			return "Image saved";
	}
	
}
