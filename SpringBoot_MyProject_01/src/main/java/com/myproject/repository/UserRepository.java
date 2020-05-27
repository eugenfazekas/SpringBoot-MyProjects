package com.myproject.repository;

import com.myproject.entity.User;

public interface UserRepository {
	
	void save(User user);

	User findByFullName(String fullname);
	
	Integer userExist(String email,String fullname);
	
	Integer activationExist(String activationCode); 
	
	void enableUser(String ActivationCode);
	
	void deleteAdminActivation(String code);
}
