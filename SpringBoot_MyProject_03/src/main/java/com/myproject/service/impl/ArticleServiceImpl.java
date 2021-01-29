package com.myproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myproject.model.Article;
import com.myproject.repository.ArticleRepository;
import com.myproject.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	private ArticleRepository articleRepository ;

	public ArticleServiceImpl(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;

	}
	
	@Override
	public void createArticleCollection() {
		
		articleRepository.createArticleCollection();
		
	}

	@Override
	public void dropArticleCollection() {
		
		articleRepository.dropArticleCollection();
		
	}

	@Override
	public void saveArticle(Article article) {

		articleRepository.saveArticle(article);
		
	}

	@Override
	public List<Article> findAllArticles() {

		return articleRepository.findAllArticles();
	}
}
