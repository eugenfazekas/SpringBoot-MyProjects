package com.myproject.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.myproject.entity.User;
import com.myproject.entity.Blog;
import com.myproject.repository.BlogRepository;
import com.myproject.repository.UserRepository;
import com.myproject.repository.Impl.BlogRepositoryImpl;
import com.myproject.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	private BlogRepository blogRepository;

	private UserRepository userRepository;
	
	@Autowired
	public BlogServiceImpl(BlogRepository blogRepository, UserRepository userRepository) {
		this.blogRepository = blogRepository;
		this.userRepository = userRepository;
	}

	@Override
	public void save(Blog blog) {

 		blog.setBlogger(bloggerNameCreator());
 		blog.setPosted(new Date());
 		blogRepository.save(blog);
		}

	@Override
	public List<Blog> findByOrderByIdDesc() {
		
		return blogRepository.findByOrderByIdDesc();
	}

	@Override
	public List<Blog> findByTiltleIgnoreCaseOrContentOrderByIdDesc(String search) {
		
		return blogRepository.findByTiltleIgnoreCaseOrContentOrderByIdDesc(search);
	}

	@Override
	public String bloggerNameCreator() {
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
		return authName;
	}

	@Override
	public void deleteBlog(String title) {

		blogRepository.deleteBlog(title);
	}
}
