package com.springsecurity.SecurityExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@Ena
public class SecurityExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityExampleApplication.class, args);
	}

}
