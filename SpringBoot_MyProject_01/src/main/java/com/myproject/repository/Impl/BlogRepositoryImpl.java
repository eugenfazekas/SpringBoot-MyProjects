package com.myproject.repository.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myproject.entity.Blog;
import com.myproject.repository.BlogRepository;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
	
private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JdbcTemplate jdbc;
	
	final RowMapper<Blog> mapper = new RowMapper<Blog>() {

		@Override
		public Blog mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			Blog n = new Blog();
			
			n.setId(rs.getLong("id"));
			n.setBlogger(rs.getString("blogger"));
			n.setTitle(rs.getString("title"));
			n.setContent(rs.getString("content"));
			n.setPosted(rs.getTimestamp("posted"));
	
			return n;
		}
	};

	@Override
	public void save(Blog blog) {
		
		final String sql = "INSERT INTO blogs (blogger,title,content,posted) VALUES (?,?,?,?)";
		jdbc.update(sql,blog.getBlogger(),blog.getTitle(),blog.getContent(),blog.getPosted());
	}

	@Override
	public List<Blog> findByOrderByIdDesc() {
		
		final String sql = "SELECT * FROM BLOGS ORDER BY id DESC";
		return jdbc.query(sql,mapper);
	}


	@Override
	public List<Blog> findByTiltleIgnoreCaseOrContentOrderByIdDesc(String inputSearch) {
		String search = "%"+inputSearch+"%";
		final String sql = "SELECT * FROM blogs WHERE title like ? OR content like ? ORDER BY id DESC";
		return jdbc.query(sql,mapper,search,search);
	}

	@Override
	public void deleteBlog(String title) {
		
		final String sql = "DELETE FROM blogs WHERE title = ? ";
		jdbc.update(sql,title);
			
	}



}
