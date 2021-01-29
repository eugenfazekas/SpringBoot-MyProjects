package com.myproject.repository;

import java.util.List;

import com.myproject.model.Article;

public interface ArticleRepository {
	
	public void createArticleCollection();
	
	public void dropArticleCollection();

	public void saveArticle(Article article);
	
	public List<Article> findAllArticles();
	
}
