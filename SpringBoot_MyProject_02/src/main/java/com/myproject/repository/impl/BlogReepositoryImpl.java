package com.myproject.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myproject.entity.BlogEntity;
import com.myproject.repository.BlogRepository;

@Repository
public class BlogReepositoryImpl implements BlogRepository{
	
private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
    JdbcTemplate jdbc;

	final RowMapper<BlogEntity> mapper = new RowMapper<BlogEntity>() {

		@Override
		public BlogEntity mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			BlogEntity n = new BlogEntity();
			
			n.setTitle(rs.getString("title"));
			n.setBlog(rs.getString("blog"));
			n.setPosted(rs.getTimestamp("posted"));
			
			return n;
		}
	};
	
	@Override
	public void insertBlog(BlogEntity blog) {
		
		final String sql = "INSERT INTO BLOGS (title,blog,posted) VALUES (? , ? , ?)";
		jdbc.update(sql, blog.getTitle(),blog.getBlog(),blog.getPosted());
		log.info("BogRepo New Blog: "+blog.toString());
	}

	@Override
	public List<BlogEntity> findBlogs() {
		
		final String sql = "SELECT * FROM BLOGS";
		
		return jdbc.query(sql,mapper);
		}

	@Override
	public List<BlogEntity> findByTiltleIgnoreCaseOrContentOrderByIdDesc(String inputSearch) {
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
