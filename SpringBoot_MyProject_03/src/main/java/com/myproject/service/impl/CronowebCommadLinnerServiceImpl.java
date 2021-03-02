package com.myproject.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.model.Address;
import com.myproject.model.Article;
import com.myproject.model.User;
import com.myproject.repository.UserRepository;
import com.myproject.service.AccountKeyService;
import com.myproject.service.ArticleService;
import com.myproject.service.CategoriesService;
import com.myproject.service.CronowebCommadLinnerService;
import com.myproject.service.UserService;

@Component
public class CronowebCommadLinnerServiceImpl implements CommandLineRunner, CronowebCommadLinnerService{	

	private UserService userservice;
	private ArticleService articleService;
	private CategoriesService categoriesService;
	private UserRepository userRepository;
	private AccountKeyService accountKeyService;

	@Override
	public void run(String... args) throws Exception {

		dropCollectionArticles();
		dropCollectionUsers();
		dropCollectionCategories();
		createCollectionArticles();
		createCollectionUsers();
		createCollectionCategories();
		createCategory();
		insertDummyCategories();
		insertDummyUsers();
		importDummyJsonArticles();
		dropCollectionAccountType();
		createCollectionAccountType();
	}

	
	public CronowebCommadLinnerServiceImpl(UserService userservice, ArticleService articleService,
			CategoriesService categoriesService, UserRepository userRepository, AccountKeyService accountKeyService) {

		this.userservice = userservice;
		this.articleService = articleService;
		this.categoriesService = categoriesService;
		this.userRepository = userRepository;
		this.accountKeyService = accountKeyService;
	}

	@Override
	public void createCollectionUsers() {
		
		userservice.createCollectionUsers();
	}

	@Override
	public void dropCollectionUsers() {
		
		userservice.dropCollectionUsers();
	}

	@Override
	public void createCollectionArticles() {

		articleService.createArticleCollection();
	}

	@Override
	public void dropCollectionArticles() {

		articleService.dropArticleCollection();
	}

	@Override
	public void createCollectionCategories() {
		
		categoriesService.createCategoriesCollection();
	}

	@Override
	public void dropCollectionCategories() {
		
		categoriesService.dropCategoriesCollection();
	}

	@Override
	public void createCategory() {
		
		categoriesService.createCategory();	
	}

	@Override
	public void insertDummyCategories() {
		
		String[] categories = {"books","cars","travel","science","nature"};
		
		for(String c : categories)
			categoriesService.addCategory(c);
			
	}

	@Override
	public void insertDummyUsers() {
		
		List<String> auhtorities = new ArrayList<String>(); auhtorities.add("user");
		
		userRepository.registerUser(new User("John","Skybolt","John Skybolt","eu@fa.hu"   ,new BCryptPasswordEncoder().encode("myPassword"),"2020.01.10 20:20:40",true,auhtorities,
				new Address("Romania","Oradea","Sovata","8")));
		
		auhtorities.add("admin");
		
		userRepository.registerUser(new User("John","Admin",  "John Admin", "admin@fa.hu",new BCryptPasswordEncoder().encode("myAdmin"),   "2020.01.10 20:20:40",true,auhtorities,
				new Address("Hungary","Debrecen","Arany Janos","2")));
	}

	@Override
	public void importDummyJsonArticles() {

	ObjectMapper mapper = new ObjectMapper();
	TypeReference<List<Article>> typeReference = new TypeReference<List<Article>>(){};
	InputStream inputStream = TypeReference.class.getResourceAsStream("/static/json/testArticles.json");
	
		try {
			List<Article> articles = mapper.readValue(inputStream, typeReference);
			articleService.insertAllArticles(articles);
		}catch(Exception e) {
			System.out.println(e);
		}
	
	}

	@Override
	public void createCollectionAccountType() {
		
		accountKeyService.createAccountKeyCollection();	
	}

	@Override
	public void dropCollectionAccountType() {
		
		accountKeyService.dropAccountKeyCollection();
	}
}
