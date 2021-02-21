package com.myproject.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.schema.JsonSchemaProperty;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema;
import org.springframework.stereotype.Repository;

import com.myproject.model.Article;
import com.myproject.repository.ArticleRepository;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
	
	 @Autowired
	private MongoTemplate mongoTemplate;
	 
	 private final String ARTICLES_COLLECTON = "articles";
	 
	@Override
	public void createArticleCollection() {
		 MongoJsonSchema schema = MongoJsonSchema.builder()                                                  
				    .required("title", "owner","published_date","content")                                     
				    .properties(
				    		JsonSchemaProperty.string("id"),         
				    		JsonSchemaProperty.string("title").minLength(3).maxLength(20),
				    		JsonSchemaProperty.string("category").minLength(3).maxLength(20),
				    		JsonSchemaProperty.string("owner").minLength(3).maxLength(40), 
				    		JsonSchemaProperty.string("published_date").minLength(3).maxLength(20),
				    		JsonSchemaProperty.string("content").minLength(5).maxLength(1000), 
				    		JsonSchemaProperty.string("image_title").minLength(5).maxLength(70))
				    	    .build();
			
			 if(!mongoTemplate.collectionExists(ARTICLES_COLLECTON))
			mongoTemplate.createCollection(ARTICLES_COLLECTON, CollectionOptions.empty().schema(schema));

			}

	@Override
	public void dropArticleCollection() {
		if(mongoTemplate.collectionExists(ARTICLES_COLLECTON))
			mongoTemplate.dropCollection(ARTICLES_COLLECTON);
	}
	
	@Override
	public void saveArticle(Article article) {
		
		mongoTemplate.save(article,"articles");				
	}

	@Override
	public List<Article> findAllArticles() {

		return mongoTemplate.findAll(Article.class,ARTICLES_COLLECTON);
	}	
	
	@Override
	public void insertAllArticles(List<Article> articles) {

		mongoTemplate.insert(articles,ARTICLES_COLLECTON);
		
		return ;
	}

	@Override
	public void deleteArticle(String articleId) {
	
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(articleId));
	    mongoTemplate.remove(query,Article.class, ARTICLES_COLLECTON);
	}

	@Override
	public Article findArticleById(String articleId) {

		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(articleId));
	    return mongoTemplate.findOne(query,Article.class, ARTICLES_COLLECTON);
	}
}
