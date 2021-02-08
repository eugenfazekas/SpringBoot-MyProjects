package com.myproject.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.schema.JsonSchemaProperty;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema;
import org.springframework.stereotype.Repository;

import com.myproject.model.Article;
import com.myproject.repository.ArticleRepository;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {
	
	 @Autowired
	private MongoTemplate mongoTemplate;
	 
	@Override
	public void createArticleCollection() {
		 MongoJsonSchema schema = MongoJsonSchema.builder()                                                  
				    .required("title", "owner","published_date","content","image_title")                                     
				    .properties(
				    		JsonSchemaProperty.string("id"),         
				    		JsonSchemaProperty.string("title").minLength(3).maxLength(20),
				    		JsonSchemaProperty.string("category").minLength(3).maxLength(20),
				    		JsonSchemaProperty.string("owner").minLength(3).maxLength(30), 
				    		JsonSchemaProperty.string("published_date").minLength(3).maxLength(20),
				    		JsonSchemaProperty.string("content").minLength(5).maxLength(1000), 
				    		JsonSchemaProperty.string("image_title").minLength(5).maxLength(20))
				    	    .build();
			
			 if(!mongoTemplate.collectionExists("articles"))
			mongoTemplate.createCollection("articles", CollectionOptions.empty().schema(schema));

			}

	@Override
	public void dropArticleCollection() {
		if(mongoTemplate.collectionExists("articles"))
			mongoTemplate.dropCollection("articles");
	}
	
	@Override
	public void saveArticle(Article article) {
		
		mongoTemplate.save(article,"articles");				
	}

	@Override
	public List<Article> findAllArticles() {

		return mongoTemplate.findAll(Article.class,"articles");
	}	
}
