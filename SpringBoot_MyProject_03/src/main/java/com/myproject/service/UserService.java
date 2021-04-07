package com.myproject.service;

import org.springframework.web.multipart.MultipartFile;

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
	
	public void uploadProfilePhoto(MultipartFile fileInput);
	
	public String deleteProfilePhoto(String userId, String photoName, boolean imageNameActive);
	
	public void setActiveProfilePhoto(String userId, String photoName);
}
