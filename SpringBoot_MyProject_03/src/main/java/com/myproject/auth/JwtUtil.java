package com.myproject.auth;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.myproject.model.User;
import com.myproject.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
	
	private String SECRET_KEY = "secret";
	@Autowired
	private UserService userService;
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Date extractExpiration(String token ) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken(UserDetails userdetails) {
		Map<String,Object> claims = new HashMap<>();
		return createToken(claims, userdetails.getUsername(), userdetails.getAuthorities(),fullName(userdetails),id(userdetails));
	}
	
	private String createToken(Map<String, Object> claims, String subject, Collection<? extends GrantedAuthority> collection, String fullName, String id) {
		return Jwts.builder().setClaims(claims).setSubject(subject).claim("authorities", collection).claim("fullName", fullName).claim("id", id).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}	
	
	public String fullName(UserDetails userdetails) {
		
		User user = userService.findUserByEmail(userdetails.getUsername());
		return user.getFullName();
	}
	
	public String id(UserDetails userdetails) {
		
		User user = userService.findUserByEmail(userdetails.getUsername());
		return user.getId();
	}
}


