package com.myproject.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.schema.JsonSchemaProperty;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema;
import org.springframework.stereotype.Repository;

import com.myproject.model.Category;
import com.myproject.repository.CategoriesRepository;

@Repository
public class CategoriesRepositoryImpl implements CategoriesRepository{
	
	 @Autowired
		private MongoTemplate mongoTemplate;
		private final String CATEGORIES_COLLECTION = "categories"; 
		@Override
		public void createCategoriesCollection() {
			 MongoJsonSchema schema = MongoJsonSchema.builder()                                                  
					    .required()                                     
					    .properties(
					    		JsonSchemaProperty.string("id"),  
					    		JsonSchemaProperty.string("category"), 
					    		JsonSchemaProperty.array("categories").items(JsonSchemaProperty.string("items")))    
					    	    .build();
				
				 if(!mongoTemplate.collectionExists("categories"))
				mongoTemplate.createCollection(CATEGORIES_COLLECTION, CollectionOptions.empty().schema(schema));

		}
		
		@Override
		public void dropCategoriesCollection() {
			if(mongoTemplate.collectionExists(CATEGORIES_COLLECTION))
				mongoTemplate.dropCollection(CATEGORIES_COLLECTION);
		}
		
		@Override
		public void createCategory() {
			
			mongoTemplate.insert(new Category("category"),CATEGORIES_COLLECTION);		
		}

		@Override
		public void addCategory(String category) {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("category").is("category"));
			mongoTemplate.updateFirst(query, new Update().push("categories", category), Category.class, CATEGORIES_COLLECTION);
		}

		@Override
		public void deleteCategory(String category) {
			
			Query query = new Query();
			query.addCriteria(Criteria.where("categories").is(category));
			mongoTemplate.remove(query,Category.class, CATEGORIES_COLLECTION);
			
		}

		@Override
		public List<Category> findAllCategories() {
			
			return mongoTemplate.findAll(Category.class, CATEGORIES_COLLECTION);
		}
}
