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
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

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
			.antMatchers("/registration").permitAll() 
			.antMatchers("/reg").permitAll()
			.antMatchers("/error/**").permitAll()
			.antMatchers("/activation/**").permitAll()
			.antMatchers("/blogs").permitAll()
			.antMatchers("/blogreg").permitAll()
			.antMatchers("/blogsearch").permitAll()
			.antMatchers("/storyreg").permitAll()
			.antMatchers("/adminreg").permitAll()
			.antMatchers("/admincheck/**").permitAll()
			.antMatchers("/getadminkey").permitAll()
			.antMatchers("/description").hasAnyAuthority("USER","ADMIN")
			.antMatchers("/videos").hasAnyAuthority("USER","ADMIN")
			.antMatchers("/blogdelete").hasAuthority("ADMIN")
			.antMatchers("/admin/addstory").hasAuthority("ADMIN")
			.antMatchers("/admin/setstory").hasAuthority("ADMIN")
			.antMatchers("/admin/stories").hasAuthority("ADMIN")
			.antMatchers("/admin/storydelete").hasAuthority("ADMIN")
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