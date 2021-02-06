package com.myproject.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.schema.JsonSchemaProperty;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema;
import org.springframework.stereotype.Repository;

import com.myproject.model.User;
import com.myproject.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	//private final Logger log = LoggerFactory.getLogger(this.getClass()); 
	private final String USERS_COLLECTION = "users";

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
			    		JsonSchemaProperty.string("password").minLength(5).maxLength(70), 
			    		JsonSchemaProperty.string("date_registered"),
			    		JsonSchemaProperty.bool("active"),
			    		JsonSchemaProperty.array("authorities").items(JsonSchemaProperty.string("items")),
			    		JsonSchemaProperty.array("articles").items(JsonSchemaProperty.string("items")))
			    	    .build();
		
		 if(!mongoTemplate.collectionExists(USERS_COLLECTION))
		mongoTemplate.createCollection(USERS_COLLECTION, CollectionOptions.empty().schema(schema));

		}

	@Override
	public void dropCollectionUsers() {
		
		if(mongoTemplate.collectionExists(USERS_COLLECTION))
		mongoTemplate.dropCollection(USERS_COLLECTION);
	}

	@Override
	public void registerUser(User user) {
		
		mongoTemplate.insert(user, USERS_COLLECTION);	
	}

	@Override
	public boolean userExistCheck(String email) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		Long users = mongoTemplate.count(query,USERS_COLLECTION);
		
		return users > 0 ? true : false;
		
	}

	@Override
	public User findUserByEmail(String email) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		User user = mongoTemplate.findOne(query,User.class, USERS_COLLECTION);
		return user;
	}
}
