package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.auth.AuthenticationRequest;
import com.myproject.auth.AuthenticationResponse;
import com.myproject.auth.JwtUtil;
import com.myproject.auth.MyUserDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	public AuthenticationManager authenticationManager;
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));	
			
		} catch(BadCredentialsException e) {
			
			throw new Exception("Incorect username or password",e);
		}
			
		final UserDetails userDetails =  myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello() {
		
		return "auth ok";
	}
}
