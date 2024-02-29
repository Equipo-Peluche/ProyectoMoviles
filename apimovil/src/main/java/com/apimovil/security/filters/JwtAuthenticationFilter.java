package com.apimovil.security.filters;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.security.core.Authentication;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.apimovil.models.entities.mongo.UserEntity;
import com.apimovil.security.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final JwtUtils jwtUtils;

	public JwtAuthenticationFilter(JwtUtils jwtUtils) {
		super();
		this.jwtUtils = jwtUtils;
	}
	
	@Override
	/**
	 * Returns optionally if header is valid
	 * 
	 * @param username	Username given by userEntity finding by request data
	 * @param password  Password given by userEntity finding by request data			
	 * 
	 * @return			Authentication
	 */
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)  {
		UserEntity userEntity;
		String username;
		String password;
		System.out.println("JwtAuthenticationFilter:intento authenticate");
		try {
			userEntity = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);
			username = userEntity.getUsername();
			password = userEntity.getPassword();
			// Returns Token based on username and password
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
					password);
			Authentication authenticate = getAuthenticationManager().authenticate(authenticationToken);
			System.out.println("JwtAuthenticationFilter: Authentication attempt");
			
			return authenticate;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	/**
	 * Function that specifies if user has authenticated successfully		
	 */
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		// Getting Authenticated user
		User user = (User) authResult.getPrincipal();
		/*	
		 * Getting response we are sending to the client
		 *  & generating the access token
		 */
		
		String accessToken = jwtUtils.generateAccessToken(user.getUsername());
		// Writing token in the header
		response.addHeader("Authorization", accessToken);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("token", accessToken);
		hashMap.put("Message", "autenticacion correcta");
		hashMap.put("usario", user.getUsername());
		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		// Writing hashmap values into the writer stream
		response.getWriter().write(new ObjectMapper().writeValueAsString(hashMap));
		response.getWriter().flush();
		// Calling super with response authenticated
		super.successfulAuthentication(request, response, chain, authResult);
		System.out.println("JwtAuthenticationFilter: User Authenticated");
	}

	@Override
	/**
	 * Function that specifies if user has failed authenticating		
	 */
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.unsuccessfulAuthentication(request, response, failed);
		System.out.println("JwtAuthenticationFilter:fallo autenticado");
	}
	
}
