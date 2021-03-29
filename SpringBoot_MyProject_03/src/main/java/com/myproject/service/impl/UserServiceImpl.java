package com.myproject.service.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.config.EmailService;
import com.myproject.model.AccountKey;
import com.myproject.model.Article;
import com.myproject.model.User;
import com.myproject.repository.UserRepository;
import com.myproject.service.AccountKeyService;
import com.myproject.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	private AccountKeyService accountKeyService;
	private EmailService emailService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public UserServiceImpl(UserRepository userRepository, AccountKeyService accountKeyService,
			EmailService emailService) {
		this.userRepository = userRepository;
		this.accountKeyService = accountKeyService;
		this.emailService = emailService;
	}

	@Override
	public void createCollectionUsers() {

		userRepository.createCollectionUsers();
	}

	@Override
	public void dropCollectionUsers() {
		
		userRepository.dropCollectionUsers();
	}

	@Override
	public void registerUser(User user) {
    
		UUID uuid = UUID.randomUUID();
		
		user.setId(uuid.toString());
	    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	    user.setFullName();
	    user.setDate_registered(getDate());
	    user.setActive(false);
		List<String> authority = new ArrayList<String>();
		authority.add("user");
		user.setAuthorities(authority);
		userRepository.registerUser(user);
		accountKeyService.createAccountKey(new AccountKey("user",uuid.toString(),user.getEmail()));
		try {
			emailService.sendMessageen(user.getEmail(), user.getFullName(), uuid.toString());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createUserDirPath(uuid.toString());
	}


	@Override
	public boolean userExistCheck(String email) {
		
		return userRepository.userExistCheck(email);
	}

	@Override
	public User findUserByEmail(String email) {
		
		User user = new User();
		try {
			user = userRepository.findUserByEmail(email);
		} catch (Exception e) {
			log.info("User Not Found!");
		}
		return user;
	}

	@Override
	public String getDate() {
		
		String pattern = "yyyy.MM.dd HH:mm:ss";
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	    
		return simpleDateFormat.format(new Date());
	}

	@Override
	public void createUserDirPath(String userId) {
		    
	    Path finaelPath = Paths.get("src/main/resources/static/user/"+ userId);
	    try {
			Files.createDirectories(finaelPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    log.debug("Directory is created!");
		
	}

	@Override
	public String userActivation(String key) {
	
		boolean userExist = accountKeyService.keyCheck(key);
		String activated = userExist == true ? "userActivated" : "notActivated";
		if(activated == "userActivated") {
			AccountKey account = accountKeyService.accountKey(key);
			userRepository.setActiveUser(account.getEmail());
			accountKeyService.removeKey(key);
		}
		return activated;
	}

	@Override
	public User updateUser(User user) {	
		String userPassword = user.getPassword() == "" ? userRepository.findUserById(user.getId()).getPassword() : new BCryptPasswordEncoder().encode(user.getPassword());
			user.setFullName();
			user.setPassword(userPassword);
		return userRepository.updateUser(user);
	}

	@Override
	public void uploadProfilePhoto(MultipartFile file) {
		
		String title = file.getOriginalFilename();
		String[] userIdInput = title.split("Ω");
		String userId = userRepository.findUserById(userIdInput[0]).getId();
		
		    try { 
		    	InputStream bis = file.getInputStream();
			    BufferedImage bImage2 = ImageIO.read(bis);
				ImageIO.write(bImage2, "png", new File("src/main/resources/static/user/" + userId + "/" + title+ ".png") );
				userRepository.uploadProfilePhoto(userId, title);
			} catch (IOException e) {
			log.debug("Erorr on saving imgae"+e.toString());
				e.printStackTrace();
			}
		
	}

	@Override
	public String deleteProfilePhoto(String userId, String imageName) {

		userRepository.deleteProfilePhoto(userId, imageName);
		String response = null;
		 File myObj = new File("src/main/resources/static/user/" + userId + "/" + imageName + ".png"); 
		    if (myObj.delete()) { 
		    	response = "Deleted the file: " + myObj.getName();
		    } else {
		    	response = "Failed to delete the file.";
		    }
		return response;
	}

	@Override
	public void setActiveProfilePhoto(String userId, String photoName) {
		
		userRepository.setActiveProfilePhoto(userId, photoName);
	}
			
}
