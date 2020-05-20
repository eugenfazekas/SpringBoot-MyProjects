package com.myproject.repository.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myproject.entity.User;
import com.myproject.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JdbcTemplate jdbc;
	
	final RowMapper<User> mapper = new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			User n = new User();
			
			n.setId(Long.valueOf(rs.getString("id")));
			n.setFirstName(rs.getString("firstname"));
			n.setLastName(rs.getString("lastname"));
			n.setEmail(rs.getString("email"));
			n.setPassword(rs.getString("password"));
			n.setActivation(rs.getString("activation"));
			n.setEnabled(Boolean.valueOf(rs.getString("enabled")));
			n.setAuthority(rs.getString("authority"));
			
			log.debug(n.toString());
			return n;
		}
	};

	@Override
	public User findByEmail(String email) {
		
		final String  sql ="SELECT * FROM users WHERE email = ?";
			return jdbc.queryForObject(sql, mapper, email);
	}

	@Override
	public void save(User user) {
		
		final String sql = "INSERT INTO users (firstname,lastname,email,password,activation,enabled,authority) VALUES (?,?,?,?,?,?,?)";
		jdbc.update(sql,user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),
				user.getActivation(),user.getEnabled().toString(),user.getAuthority());
	}
}
