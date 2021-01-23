package com.myproject.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.myproject.entity.PackageEntity;
import com.myproject.repository.PackageRepository;

@Repository
public class PackageRepositoryImpl implements PackageRepository{

//private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
    JdbcTemplate jdbc;

	final RowMapper<PackageEntity> mapper = new RowMapper<PackageEntity>() {

		@Override
		public PackageEntity mapRow(ResultSet rs ,int rowNum) throws SQLException {
			
			PackageEntity n = new PackageEntity();
			
			n.setTitle(rs.getString("title"));
			n.setNumber_of_pages(rs.getInt("number_of_pages"));
			n.setNumber_of_page_elements(rs.getInt("number_of_page_elements"));
			n.setSsl(rs.getBoolean("ssl"));
			n.setMessage_sending(rs.getBoolean("message_sending"));
			n.setDatabase_type(rs.getString("database_type"));
			n.setMulti_language(rs.getBoolean("multi_language"));
			n.setSite_search(rs.getBoolean("site_search"));
			n.setBlogging(rs.getBoolean("blogging"));
			n.setAnimations(rs.getBoolean("animations"));
			n.setUser_authentication(rs.getBoolean("user_authentication"));
			n.setNewsletter_service(rs.getBoolean("newsletter_service"));
			n.setPagination(rs.getBoolean("pagination"));
			n.setPrice(rs.getInt("price"));
			
			return n;
		}
	};

	@Override
	public List<PackageEntity> findPackages() {
		
		final String sql = "SELECT * FROM PACKAGES";
		
		return jdbc.query(sql,mapper);
		}

	@Override
	public List<PackageEntity> findPackagesBySpec(String html_page, String html_elements, String db, String search,
			String multilanguage, String animation, String auth, String newsletter) {
		
		final String sql = "SELECT * FROM PACKAGES WHERE description4 = ? AND description5 = ? AND description8 = ? AND description9 = ? AND description10 = ?"
				+ " AND description12 = ? AND description13 = ? AND description14 = ? ";
		
		return jdbc.query(sql,mapper,html_page,html_elements,db,multilanguage,search,animation,auth,newsletter);
	}

}
