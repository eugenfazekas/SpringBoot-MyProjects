package com.myproject.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myproject.entity.ImageEntity;
import com.myproject.repository.ImageRepository;

@Repository
public class ImageRepositoryImpl implements ImageRepository {

	@Autowired
	JdbcTemplate jdbc;
	
	final RowMapper<ImageEntity> mapper = new RowMapper<ImageEntity>() {

		@Override
		public ImageEntity mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			ImageEntity n = new ImageEntity();
			
			n.setId(Long.valueOf(rs.getString("id")));
			n.setName(rs.getString("name"));
			n.setData(rs.getBytes("data"));
			n.setPosted(rs.getString("posted"));
	
			return n;
		}
	};
	
	public void save (ImageEntity image) {
		
		String sql = " INSERT INTO images (name,data,posted) VALUES (?,?,?)";
		jdbc.update(sql,image.getName(),image.getData(),image.getPosted());
	}

	public ImageEntity findByName(String name) {
		
		String sql = "SELECT * FROM images where name = ?";
		return jdbc.queryForObject(sql,mapper,name);
		
	}

	@Override
	public List<ImageEntity> findAllImages() {
		
		String sql = "SELECT * FROM images ";
		return jdbc.query(sql,mapper);
	}
}
