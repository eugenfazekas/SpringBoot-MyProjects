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
			n.setDescription1(rs.getString("description1"));
			n.setDescription2(rs.getString("description2"));
			n.setDescription3(rs.getString("description3"));
			n.setDescription4(rs.getString("description4"));
			n.setDescription5(rs.getString("description5"));
			n.setDescription6(rs.getString("description6"));
			n.setDescription7(rs.getString("description7"));
			n.setDescription8(rs.getString("description8"));
			n.setDescription9(rs.getString("description9"));
			n.setDescription10(rs.getString("description10"));
			n.setDescription11(rs.getString("description11"));
			n.setDescription12(rs.getString("description12"));
			n.setDescription13(rs.getString("description13"));
			n.setDescription14(rs.getString("description14"));
			n.setDescription15(rs.getString("description15"));
			n.setPrice(rs.getString("price"));
			
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
