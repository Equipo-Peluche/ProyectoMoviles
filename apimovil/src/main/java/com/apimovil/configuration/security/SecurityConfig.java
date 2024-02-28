package com.apimovil.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.apimovil.security.JwtUtils;
import com.apimovil.security.filters.JwtAuthenticationFilter;
import com.apimovil.security.filters.JwtAuthorizationFilter;
import com.apimovil.services.UserDetailsServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableMethodSecurity
public class SecurityConfig {

	private final UserDetailsServiceImpl userDetailsServiceImpl;
	private final JwtUtils jwtUtils;
	private final JwtAuthorizationFilter jwtAuthorizationFilter;

	public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl, JwtUtils jwtUtils,
			JwtAuthorizationFilter jwtAuthorizationFilter) {
		super();
		this.userDetailsServiceImpl = userDetailsServiceImpl;
		this.jwtUtils = jwtUtils;
		this.jwtAuthorizationFilter = jwtAuthorizationFilter;
	}

	@Bean
	/**
	 * Returns a SecurityFilterChain to authenticate via JWT
	 * 
	 * @return     the SecurityFilterChain Interface implementation
	 */
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationManager authenticationManager)
			throws Exception {
		// The JWT authentication
		JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(jwtUtils);
		jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
		jwtAuthenticationFilter.setFilterProcessesUrl("/login");
		// HTTP authentication
		DefaultSecurityFilterChain httpsec = 
				httpSecurity
				.csrf((cs) -> cs.disable())
				.authorizeHttpRequests((auth) -> {
						// Matches request of the routes that will not have authentication
						auth.requestMatchers("moviles").permitAll();
						// Any other request, requires authentication
						auth.anyRequest().authenticated();
						})
				.sessionManagement((sess) -> {
						sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
						})
				// Adding custom JWT filters
				.addFilter(jwtAuthenticationFilter)
				.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
		log.info("SecurityConfig:terminando configuracion config");
		return httpsec;
	}

	@Bean
	/**
	 * Returns a new password encoder Object
	 * @return     the BCrypt password encoder
	 */
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	/**
	 * @param username Username given by the user
	 * @param password Password given in the body
	 * 
	 * 	When user authenticates via username and password this manager will use
	 *  "USerDetailsManager" to know if there is any user with these credentials
	 * 
	 */
	AuthenticationManager authenticationManager(HttpSecurity httpSecurity, PasswordEncoder passwordEncoder)
			throws Exception {
		AuthenticationManager authenticationManager = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder).and().build();
		log.debug("SecurityConfig:generando autentication manager");
		return authenticationManager;
	}
	
	
	
}
