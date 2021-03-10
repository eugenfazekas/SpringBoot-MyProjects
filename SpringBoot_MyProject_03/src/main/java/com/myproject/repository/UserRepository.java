package com.myproject.repository;

import com.myproject.model.User;

public interface UserRepository {

	public void createCollectionUsers();
	
	public void dropCollectionUsers();
	
	public void registerUser(User user);
	
	public boolean userExistCheck(String email);
	
	public User findUserByEmail(String email) throws Exception;
	
	public void addArticle(String userFullName, String article);
	
	public void deleteArticle(String userFullName, String article);
	
	public User findUserById(String id);
	
	void setActiveUser(String email);

	public User updateUser(User user);
}
