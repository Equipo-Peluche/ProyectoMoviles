package com.apimovil.security.filters;

import java.io.IOException;
import java.util.Optional;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.apimovil.security.JwtUtils;
import com.apimovil.services.UserDetailsServiceImpl;
import com.mongodb.lang.NonNull;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {
	private final JwtUtils jwtUtils;
	private final UserDetailsServiceImpl userDetailsServiceImpl;

	public JwtAuthorizationFilter(JwtUtils jwtUtils, UserDetailsServiceImpl userDetailsServiceImpl) {
		super();
		this.jwtUtils = jwtUtils;
		this.userDetailsServiceImpl = userDetailsServiceImpl;
	}

	
	@Override
	/**
	 * This function do the filtering 
	 * 
	 * @param  HttpServletRequest   Extends the ServletRequest interface to provide 
	 * 								request information for HTTP servlets
	 * @param  HttpServletResponse  methods to access HTTP headers and cookies
	 * @param  FilterChain   		Filtering request of a resource
	 * 
	 * 
	 * @exception					ServletException
	 * @exception					IOException
	 */
	protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response,
			@NonNull FilterChain filterChain) throws IOException, ServletException {
		System.out.println("JwtAuthorizationFilter: initializing filter");
		String header = request.getHeader("Authorization");
		System.out.println("JwtAuthorizationFilter: Header data: " + header);
		isValidBearerHeader(header).ifPresent((head) -> {
			// If every token is valid, continue getting username authentication
			if (jwtUtils.isTokenValid(head)) {
				// Getting username data
				String username = jwtUtils.getUSerNameFromToken(head);
				UserDetails userByUsername = userDetailsServiceImpl.loadUserByUsername(username);
				// Getting user authentication token via username
				UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, null,
						userByUsername.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(token);
			}
		});
		filterChain.doFilter(request, response);
	}
	/**
	 * Returns optionally if header is valid
	 * 
	 * When header is not null, and starts with "Bearer "
	 * 
	 * @return			Token
	 */
	private Optional<String> isValidBearerHeader(String header) {
		String prefix = "Bearer ";
		return header != null && header.startsWith(prefix) ? Optional.of(header.substring(prefix.length()))
				: Optional.ofNullable(null);
	}
}
