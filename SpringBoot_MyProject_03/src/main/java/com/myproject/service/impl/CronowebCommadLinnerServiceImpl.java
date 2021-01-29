package com.myproject.service.impl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myproject.service.ArticleService;
import com.myproject.service.CronowebCommadLinnerService;
import com.myproject.service.UserService;

@Component
public class CronowebCommadLinnerServiceImpl implements CommandLineRunner, CronowebCommadLinnerService{	

	private UserService userservice;
	private ArticleService articleService;

	public CronowebCommadLinnerServiceImpl(UserService userservice, ArticleService articleService) {
		this.userservice = userservice;
		this.articleService = articleService;
	}

	@Override
	public void run(String... args) throws Exception {

		dropCollectionArticles();
		dropCollectionUsers();
		createCollectionArticles();
		createCollectionUsers();
	}

	@Override
	public void createCollectionUsers() {
		
		userservice.createCollectionUsers();
	}

	@Override
	public void dropCollectionUsers() {
		
		userservice.dropCollectionUsers();
	}

	@Override
	public void createCollectionArticles() {

		articleService.createArticleCollection();
	}

	@Override
	public void dropCollectionArticles() {

		articleService.dropArticleCollection();
	}
}
