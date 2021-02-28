package com.myproject.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.schema.JsonSchemaProperty;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema;
import org.springframework.stereotype.Repository;

import com.myproject.model.AccountKey;
import com.myproject.repository.AccountKeyRepository;

@Repository
public class AccountKeyRepositoryImpl  implements AccountKeyRepository{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	private final String ACCOUNT_KEYS_COLLECTION = "accountkeys"; 
	
	@Override
	public void createAccountKeyCollection() {
		 MongoJsonSchema schema = MongoJsonSchema.builder()                                                  
				    .required()                                     
				    .properties(
				    		JsonSchemaProperty.string("accountType"),  
				    		JsonSchemaProperty.string("key")) 
				    	    .build();
			
			 if(!mongoTemplate.collectionExists(ACCOUNT_KEYS_COLLECTION))
			mongoTemplate.createCollection(ACCOUNT_KEYS_COLLECTION, CollectionOptions.empty().schema(schema));

	}
	
	@Override
	public void dropAccountKeyCollection() {
		if(mongoTemplate.collectionExists(ACCOUNT_KEYS_COLLECTION))
			mongoTemplate.dropCollection(ACCOUNT_KEYS_COLLECTION);
		
	}

	@Override
	public void createAccountKey(AccountKey account) {

		mongoTemplate.insert(account, ACCOUNT_KEYS_COLLECTION);
	}

	@Override
	public boolean keyCheck(String key) {
		
		BasicQuery query = new BasicQuery("{ \"key\" : \"" + key + "\"}");
		Long users = mongoTemplate.count(query, ACCOUNT_KEYS_COLLECTION);
		
		return users > 0 ? true : false;
		
	}
	
	@Override
	public AccountKey accountKey(String key) {
		
		BasicQuery query = new BasicQuery("{ \"key\" : \"" + key + "\"}");
		return mongoTemplate.findOne(query, AccountKey.class, ACCOUNT_KEYS_COLLECTION);
	}

	@Override
	public void removeKey(String key) {

		BasicQuery query = new BasicQuery("{ \"key\" : \"" + key + "\"}");
		mongoTemplate.remove(query, ACCOUNT_KEYS_COLLECTION);
	}
}
