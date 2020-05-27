package com.myproject.repository.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
			n.setFullName(rs.getString("fullname"));
			n.setEmail(rs.getString("email"));
			n.setPassword(rs.getString("password"));
			n.setActivation(rs.getString("activation"));
			n.setEnabled(Boolean.valueOf(rs.getString("enabled")));
			n.setAuthority(rs.getString("authority"));
			
			return n;
		}
	};

	@Override
	public User findByFullName(String fullname) {

		User user = null;
		final String  sql ="SELECT * FROM users WHERE fullname = ?";
		try {
		user = jdbc.queryForObject(sql, mapper, fullname);
		}catch(EmptyResultDataAccessException e) {
			log.debug("Fullname: "+fullname+" Not Fonud!");
			}
		return user;
		}

	@Override
	public void save(User user) {
		
		final String sql = "INSERT INTO users (fullname,email,password,activation,enabled,authority) VALUES (?,?,?,?,?,?)";
		jdbc.update(sql,user.getFullName(),user.getEmail(),user.getPassword(),
				user.getActivation(),user.getEnabled().toString(),user.getAuthority());
	}

	@Override
	public Integer userExist(String email, String fullname ) {
	
		final String  sql = "SELECT COUNT (*)  from users where email = ? or fullname = ? ";
		int user = jdbc.queryForObject(sql, new Object[] {email,fullname}, Integer.class); 
	
			return user;
	}
	
	@Override
	public Integer activationExist(String activationCode) {
		
		final String  sql ="SELECT COUNT (activation) FROM USERS WHERE activation = ?";
		int user = jdbc.queryForObject(sql, new Object[] {activationCode}, Integer.class);
			
		return user;
	}

		@Override
		public void enableUser(String activationCode ) {
			
			final String  sql ="UPDATE users SET activation = '' , enabled = 'true' where activation = ? ";
			jdbc.update(sql, activationCode);
	}

		@Override
		public void deleteAdminActivation(String code) {
			
			final String  sql ="DELETE FROM users where activation = ? ";
			jdbc.update(sql, code);
		}
		
}

