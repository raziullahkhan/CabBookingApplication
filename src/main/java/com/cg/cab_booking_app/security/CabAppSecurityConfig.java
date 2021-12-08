package com.cg.cab_booking_app.security;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

@Configuration
@EnableWebSecurity
public class CabAppSecurityConfig extends WebSecurityConfigurerAdapter {


	@SuppressWarnings("deprecation")
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("capgemini").password("12345").roles("ADMIN").build());
		users.add(User.withDefaultPasswordEncoder().username("Razi").password("12345").roles("USER").build());
		users.add(User.withDefaultPasswordEncoder().username("Mustafiz").password("12345").roles("USER").build());
		users.add(User.withDefaultPasswordEncoder().username("Naveen").password("12345").roles("USER").build());
		users.add(User.withDefaultPasswordEncoder().username("Nikhil").password("12345").roles("USER").build());
		users.add(User.withDefaultPasswordEncoder().username("Pinaki").password("12345").roles("USER").build());
		
		return  new  InMemoryUserDetailsManager(users);
		
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	     http       //other configure params.
	         .csrf().disable();
	}
//	 protected void configure(HttpSecurity http) throws Exception {  
//         
//	        http  
//			.csrf().disable()
//			.formlogin()
//	        .antMatcher("/")                                 
//	        .authorizeRequests()  
//	            .anyRequest().hasRole("ADMIN")  
//	            .and()  
//	        .httpBasic();  
//	    }  

}
