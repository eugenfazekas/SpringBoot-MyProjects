package com.myproject.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.schema.JsonSchemaProperty;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema;
import org.springframework.stereotype.Repository;

import com.myproject.model.User;
import com.myproject.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void createCollectionUsers() {	

	 MongoJsonSchema schema = MongoJsonSchema.builder()                                                  
			    .required("firstName", "lastName","fullName","email","password", "active")                                     
			    .properties(
			    		JsonSchemaProperty.string("id"),         
			    		JsonSchemaProperty.string("firstName").minLength(3).maxLength(15),
			    		JsonSchemaProperty.string("lastName").minLength(3).maxLength(15), 
			    		JsonSchemaProperty.string("fullName").minLength(3).maxLength(30),
			    		JsonSchemaProperty.string("email").matching("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$").minLength(5).maxLength(50), 
			    		JsonSchemaProperty.string("password").minLength(5).maxLength(20), 
			    		JsonSchemaProperty.bool("active"), 
			    		JsonSchemaProperty.array("articles").items(JsonSchemaProperty.string("items")))
			    	    .build();
		
		 if(!mongoTemplate.collectionExists("users"))
		mongoTemplate.createCollection("users", CollectionOptions.empty().schema(schema));

		}

	@Override
	public void dropCollectionUsers() {
		
		if(mongoTemplate.collectionExists("users"))
		mongoTemplate.dropCollection("users");
	}

	@Override
	public void registerUser(User user) {
		
		mongoTemplate.insert(user, "users");	
	}
}
