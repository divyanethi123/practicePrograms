package com.springsecurity.SecurityExample.SpringConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfig {
//    @Bean
//    SecurityFilterChain defaultSecururityFilter(HttpSecurity http) throws Exception{
//
////      http.authorizeHttpRequests()
////              .requestMatchers("/myAccount").authenticated()
////              .requestMatchers("/notices","/contacts").permitAll()
////              .and().formLogin()
////              .and().httpBasic();
//
//        http.authorizeHttpRequests()
//                .requestMatchers("/myAccount","/myBalance","/myLoans","/myCards").authenticated()
//                .requestMatchers("/notices","/contact").permitAll()
//                .and().formLogin()
//                .and().httpBasic();
//        return http.build();
//
//    }

}
