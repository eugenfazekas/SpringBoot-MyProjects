package com.myproject.service;

import com.myproject.model.User;

public interface UserService {
	
	public void createCollectionUsers();
	
	public void dropCollectionUsers();
	
	public void registerUser(User user);
	
	public boolean userExistCheck(String email);
	
	public User findUserByEmail(String email);
	
	public String getDate();
	
	public void createUserDirPath(String userId);
	
	public String userActivation(String key);

	public User updateUser(User user);		
}
