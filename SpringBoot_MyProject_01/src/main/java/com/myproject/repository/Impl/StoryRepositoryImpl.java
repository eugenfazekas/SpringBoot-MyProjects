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

import com.myproject.entity.Story;
import com.myproject.repository.StoryRepository;

@Repository
public class StoryRepositoryImpl implements StoryRepository {
	
private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JdbcTemplate jdbc;
	
	final RowMapper<Story> mapper = new RowMapper<Story>() {

		@Override
		public Story mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			Story n = new Story();
			
			n.setId(Long.valueOf(rs.getString("id")));
			n.setTitle(rs.getString("title"));
			n.setContent1(rs.getString("content1"));
			n.setContent2(rs.getString("content2"));
			n.setContent3(rs.getString("content3"));
			n.setImage1(rs.getString("image1"));
			n.setVideo1(rs.getString("video1"));
			n.setCreated(rs.getTimestamp("created"));
			n.setActive(rs.getString("active"));
			
			return n;
		}
	};
	
	@Override
	public void save(Story story) {
		final String sql = "INSERT INTO stories (title,content1,content2,content3,image1,video1,created) VALUES (?,?,?,?,?,?,?)";
		jdbc.update(sql,story.getTitle(),story.getContent1(),story.getContent2(),
		story.getContent3(),story.getImage1(),story.getVideo1(),story.getCreated());
	}

	@Override
	public List<Story> findByOrderByIdDesc() {
		final String sql = "SELECT * FROM stories ORDER BY id DESC";
		return jdbc.query(sql,mapper);
	}

	@Override
	public Story findByActivation() {
		final String sql = "SELECT * FROM stories WHERE active = 'ACTIVE' ";
		return jdbc.queryForObject(sql,mapper);
	}

	@Override
	public void deleteByTitle(String title) {
		final String sql = "DELETE FROM stories WHERE title = ? ";
		jdbc.update(sql,title);
	}

	@Override
	public Integer storyExist(String title) {
			
		final String  sql = "SELECT COUNT (*)  FROM stories WHERE title = ? ";
		int stories = jdbc.queryForObject(sql, new Object[] {title}, Integer.class); 
		
				return stories ;
		}

	@Override
	public void setStoryActive(String title) {
		final String  sql ="UPDATE stories SET active = 'ACTIVE' where title = ? ";
		jdbc.update(sql, title);
		
	}

	@Override
	public void setStoryInactive() {
		final String  sql ="UPDATE stories SET active = 'INACTIVE' where active = 'ACTIVE' ";
		jdbc.update(sql);
	}

	@Override
	public Integer activeStoryExsit() {
		final String  sql = "SELECT COUNT (*)  FROM stories WHERE active = 'ACTIVE' ";
		int activestory = jdbc.queryForObject(sql, new Object[] {}, Integer.class); 
		
		return activestory;
	}
	
	
	}


