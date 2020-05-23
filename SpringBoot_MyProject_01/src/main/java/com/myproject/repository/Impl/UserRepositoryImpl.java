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
	public Integer emailExist(String email) {
	
		final String  sql ="SELECT COUNT (email) FROM USERS WHERE email = ?";
		int user = jdbc.queryForObject(sql, new Object[] {email}, Integer.class);
	
			return user;
	}
	
	@Override
	public String findByActivation(String activationCode) {
		String activation = "NotOK!";
		
		final String  sql1 ="SELECT COUNT (activation) FROM USERS WHERE activation = ?";
		int user = jdbc.queryForObject(sql1, new Object[] {activationCode}, Integer.class);
	
		if(user > 0) {
		final String  sql2 ="UPDATE users SET activation = '' , enabled = 'true' where activation = ? ";
		jdbc.update(sql2, activationCode);
		activation = "Ok";
			}
		log.debug("Account activation: " + activation);
			return activation;
	}
}
