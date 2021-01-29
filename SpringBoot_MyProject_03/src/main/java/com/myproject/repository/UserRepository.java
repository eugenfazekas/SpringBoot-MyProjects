package com.myproject.repository;

import com.myproject.model.User;

public interface UserRepository {

	public void createCollectionUsers();
	
	public void dropCollectionUsers();
	
	public void registerUser(User user);

}
