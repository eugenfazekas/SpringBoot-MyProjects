package com.myproject.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.myproject.model.Article;
import com.myproject.service.ArticleService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("article")
public class ArticleController {
	
	private ArticleService articleService;

	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}


	@RequestMapping(value = "saveArticle", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Article registerUser(@RequestBody Article article) {

		articleService.saveArticle(article);
		
	    return article;
	}

}
