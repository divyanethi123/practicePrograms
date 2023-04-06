package com.exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exam.filter.JWTFilter;
import com.exam.serviceimpl.UserService;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	AuthenticationProvider authenticationProvider;
	@Autowired
 private UserService userService;
	@Autowired
	private JWTFilter jwtfilter;


	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.csrf().disable().authorizeRequests()
		.antMatchers("/authenticate","/distinctcount","/accurence","/get","/filter","/endswith","/startwith","/search","/save","/").permitAll()
		.anyRequest().authenticated().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
	}
@Bean
public AuthenticationManager authentications(AuthenticationManagerBuilder auth) throws Exception {
	
	return super.authenticationManagerBean();
}

}
