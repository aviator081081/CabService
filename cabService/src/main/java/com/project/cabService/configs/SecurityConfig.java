package com.project.cabService.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration

@EnableWebSecurity
public class SecurityConfig {

//	@Autowired
//	private UserDetailsService userDetailsService;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().anyRequest().authenticated().and().oauth2Login().and().logout()
				.clearAuthentication(true).invalidateHttpSession(true).deleteCookies("JSESSIONID")
				.logoutSuccessUrl("/admin/loggedOut").permitAll();
		return http.build();
	}

//	@Bean
//	public SecurityFilterChain(AuthenticationManagerBuilder auth) {
//		
//	}
}
