package com.apimovil.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import com.apimovil.models.entities.mongo.UserEntity;
import com.apimovil.repositories.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//esto vale para obtener el usuario entity en nuestra bbdd
		UserEntity user = userRepository.findByUsername(username)
			.orElseThrow(()->new UsernameNotFoundException("usuario inexistente"));
		//esto vale para convertir sus roles en roles reales de Spring Security
		Set<SimpleGrantedAuthority> set=user.getRoles().stream()
			.map((rol)-> new SimpleGrantedAuthority("ROLE_"+rol.getName().name()))
			.collect(Collectors.toSet());
		log.debug("UserDetailsServiceImpl:"+"load user"+user.getUsername());
		//ahora tenemos que crear un usuario de Security
		User user2 = new User(user.getUsername(),user.getPassword(),set);
		return user2;
	}
}
