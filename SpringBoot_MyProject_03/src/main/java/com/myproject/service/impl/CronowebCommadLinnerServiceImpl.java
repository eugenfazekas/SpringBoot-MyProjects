package com.myproject.service.impl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myproject.service.ArticleService;
import com.myproject.service.CategoriesService;
import com.myproject.service.CronowebCommadLinnerService;
import com.myproject.service.UserService;

@Component
public class CronowebCommadLinnerServiceImpl implements CommandLineRunner, CronowebCommadLinnerService{	

	private UserService userservice;
	private ArticleService articleService;
	private CategoriesService categoriesService;
	
	public CronowebCommadLinnerServiceImpl(UserService userservice, ArticleService articleService,
			CategoriesService categoriesService) {
		
		this.userservice = userservice;
		this.articleService = articleService;
		this.categoriesService = categoriesService;
	}

	@Override
	public void run(String... args) throws Exception {

		dropCollectionArticles();
		dropCollectionUsers();
		dropCollectionCategories();
		createCollectionArticles();
		createCollectionUsers();
		createCollectionCategories();
		createCategory();
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

	@Override
	public void createCollectionCategories() {
		
		categoriesService.createCategoriesCollection();
	}

	@Override
	public void dropCollectionCategories() {
		
		categoriesService.dropCategoriesCollection();
	}

	@Override
	public void createCategory() {
		
		categoriesService.createCategory();	
	}
}
