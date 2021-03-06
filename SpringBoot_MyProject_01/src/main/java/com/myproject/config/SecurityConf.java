package com.myproject.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myproject.service.Impl.UserServiceImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceImpl	userServiceImpl;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception {
				
		auth.userDetailsService(userServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
		}
	
	@Override 
	protected void configure(HttpSecurity httpSec) throws Exception {
		
		httpSec
		.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/index/**").permitAll()
			.antMatchers("/user/**").hasAnyAuthority("USER","ADMIN")
			.antMatchers("/admin/**").hasAuthority("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
		.logout()
			.logoutSuccessUrl("/login?logout")
			.permitAll();
}	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/db/**");
	    web.ignoring().antMatchers("/css/**");
	    web.ignoring().antMatchers("/img/**");
	    web.ignoring().antMatchers("/templates/**");
	}

}