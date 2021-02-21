package com.myproject.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.myproject.auth.JwtRequestFilter;
import com.myproject.auth.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {
		
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.csrf().disable().authorizeRequests().antMatchers("/user/**").permitAll()
									.antMatchers("/authenticate").permitAll()
									.antMatchers("/admin/**").hasAuthority("admin")
									.anyRequest().authenticated()
									.and().sessionManagement()
									.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		 http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		 http.cors();						
		}	
}


