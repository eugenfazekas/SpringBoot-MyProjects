package com.myproject.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.myproject.entity.User;
import com.myproject.entity.Blog;
import com.myproject.repository.UserRepository;
import com.myproject.repository.Impl.BlogRepositoryImpl;
import com.myproject.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	private BlogRepositoryImpl blogRepositoryImpl;
	
	private UserRepository userRepository;
		
	@Autowired
	public BlogServiceImpl(BlogRepositoryImpl blogRepositoryImpl, UserRepository userRepository) {
		this.blogRepositoryImpl = blogRepositoryImpl;
		this.userRepository = userRepository;
	}
	
	

	@Override
	public void save(Blog blog) {
		
		String authName = "Anonymous";
 		 	Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();{
 		 		if (principal instanceof UserDetails) {
		    	  String fullname = ((UserDetails)principal).getUsername();
		    	  User user = userRepository.findByFullName(fullname);
		    	  if(user.getFullName() != null) {
		    	  authName = user.getFullName() ;
		    	  	}
 		 		}  
 		 	}
 		 		blog.setBlogger(authName);
 		 			blogRepositoryImpl.save(blog);
		}



	@Override
	public List<Blog> findByOrderByIdDesc() {
		
		return blogRepositoryImpl.findByOrderByIdDesc();
	}

	@Override
	public List<Blog> findByTiltleIgnoreCaseOrContentOrderByIdDesc(String search) {
		
		return blogRepositoryImpl.findByTiltleIgnoreCaseOrContentOrderByIdDesc(search);
	}

	



}
