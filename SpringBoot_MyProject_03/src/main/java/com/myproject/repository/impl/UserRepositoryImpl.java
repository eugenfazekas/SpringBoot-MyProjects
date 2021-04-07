package com.myproject.repository.impl;

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
			    		JsonSchemaProperty.string("activeProfilePhoto").maxLength(70), 
			    		JsonSchemaProperty.array("authorities").items(JsonSchemaProperty.string("items")),
			    		JsonSchemaProperty.object("Address").properties(
			    														JsonSchemaProperty.string("country").possibleValues("Romania","Hungary","UK"),
			    														JsonSchemaProperty.string("city").minLength(3).maxLength(20), 
			    														JsonSchemaProperty.string("street").minLength(3).maxLength(25), 
			    														JsonSchemaProperty.string("number").minLength(3).maxLength(1) 
			    									),
			    		JsonSchemaProperty.array("profilePhotos").items(JsonSchemaProperty.string("items")),
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

	@Override
	public void addArticle(String userFullName, String article) {

		Query query = new Query();
		query.addCriteria(Criteria.where("fullName").is(userFullName));
		mongoTemplate.updateFirst(query, new Update().push("articles", article), Category.class, USERS_COLLECTION);
	}

	@Override
	public void deleteArticle(String userFullName, String article) {

		Query query = new Query();
		query.addCriteria(Criteria.where("fullName").is(userFullName));
		mongoTemplate.updateFirst(query, new Update().pull("articles", article), Category.class, USERS_COLLECTION);
		
	}

	@Override
		public User findUserById(String id) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		User user = mongoTemplate.findOne(query, User.class, USERS_COLLECTION);
		return user;
		
	}

	@Override
	public void setActiveUser(String email) {
	
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		Update update = new Update();
		update.set("active", true);
		mongoTemplate.updateFirst(query, update, USERS_COLLECTION);
	}

	@Override
	public User updateUser(User user) {
			Query query = new Query();
			query.addCriteria(Criteria.where("id").is(user.getId()));
			Update update = new Update();
			update.set("firstName", user.getFirstName());
			update.set("lastName", user.getLastName());
			update.set("fullName", user.getFullName());
			update.set("email", user.getEmail());
			update.set("password", user.getPassword());
			update.set("address", user.getAddress());
			mongoTemplate.updateMulti(query, update, User.class, USERS_COLLECTION);
		return user;
	}

	@Override
	public void uploadProfilePhoto(String userId, String photoName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(userId));
		mongoTemplate.updateFirst(query, new Update().push("profilePhotos", photoName), User.class, USERS_COLLECTION);	
	}

	@Override
	public void deleteProfilePhoto(String userId, String photoName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(userId));
		mongoTemplate.updateFirst(query, new Update().pull("profilePhotos", photoName), User.class, USERS_COLLECTION);	
	}

	@Override
	public void setActiveProfilePhoto(String userId, String photoName) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(userId));
		Update update = new Update();
		update.set("activeProfilePhoto", photoName);
		mongoTemplate.updateFirst(query, update, User.class, USERS_COLLECTION);	
	}		
}
