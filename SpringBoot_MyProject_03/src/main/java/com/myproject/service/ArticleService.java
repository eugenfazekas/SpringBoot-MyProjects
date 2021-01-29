package com.myproject.service;

import java.util.List;

import com.myproject.model.Article;

public interface ArticleService {
	
	public void createArticleCollection();
	
	public void dropArticleCollection();

	public void saveArticle(Article article);
	
	public List<Article> findAllArticles();
}
