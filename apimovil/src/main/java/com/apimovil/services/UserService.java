package com.apimovil.services;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.apimovil.models.ERole;
import com.apimovil.models.dto.UserCreateDTO;
import com.apimovil.models.entities.mongo.RoleUser;
import com.apimovil.models.entities.mongo.UserEntity;
import com.apimovil.models.mappers.UserCreateDTO2UserMapper;
import com.apimovil.repositories.RoleRepository;
import com.apimovil.repositories.UserRepository;

import io.jsonwebtoken.lang.Arrays;
@Service
public class UserService {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final UserCreateDTO2UserMapper userCreateDTO2UserMapper;

	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			UserCreateDTO2UserMapper userCreateDTO2UserMapper) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.userCreateDTO2UserMapper = userCreateDTO2UserMapper;
	}

	// igual es momento de usar Response
	public boolean createUser(UserCreateDTO userCreateDTO) {
		UserEntity user = userCreateDTO2UserMapper.map(userCreateDTO);
		if (userCreateDTO.roles() != null) {
			Set<RoleUser> roles = fillRoles(userCreateDTO.roles());
			user.setRoles(roles);
		}
		if (userRepository.save(user) != null) {
			return true;
		}
		return false;
	}

	private Set<RoleUser> fillRoles(String[] t) {
		if (ERole.validate(t)) {
			return Arrays.asList(t).stream()
					.map((rol) -> {
							ERole rolresult = ERole.getRole(rol).get();
							Optional<RoleUser> byName = roleRepository.findByName(rolresult);
							RoleUser roleEntity = byName.get();
							return roleEntity;
						})
					.collect(Collectors.toSet());
		}
		return null;
	}

	public boolean delete(String username) {
		Optional<UserEntity> byUsername = userRepository.findByUsername(username);
		userRepository.delete(byUsername.get());
//		userRepository.deleteByUsername(username);
		return true;
	}
	public boolean deleteAll() {
		userRepository.deleteAll();
		return true;
	}
}
