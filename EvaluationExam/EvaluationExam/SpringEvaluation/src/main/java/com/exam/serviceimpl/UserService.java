package com.exam.serviceimpl;

import java.util.ArrayList;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ArrayList< GrantedAuthority> gr=new ArrayList<>();
		SimpleGrantedAuthority sim=new SimpleGrantedAuthority("user");
		gr.add(sim);
		User user=new User("admin", "password", gr);
		return user;
	}
	

}
