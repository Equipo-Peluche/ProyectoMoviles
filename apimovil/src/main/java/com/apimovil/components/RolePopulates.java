package com.apimovil.components;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.apimovil.models.ERole;
import com.apimovil.models.dto.UserCreateDTO;
import com.apimovil.models.entities.mongo.RoleUser;
import com.apimovil.repositories.RoleRepository;
import com.apimovil.services.UserService;

import jakarta.annotation.PostConstruct;

@Component
public class RolePopulates {
	private final RoleRepository roleRepository;
	private final UserService userService;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String bbddStatus;

	public RolePopulates(RoleRepository roleRepository, UserService userService) {
		super();
		this.roleRepository = roleRepository;
		this.userService = userService;
	}

	//debido al orden en que se cargan las clases de Spring
	//hay que asegurarse de que algunas cosas van al final
	@PostConstruct
	public void init() {
		if (!bbddStatus.equals("update")) {
			populateRoles();
			populateUsers();
		}
	}
	public void populateRoles() {
		for (ERole erole : ERole.values()) {
			if (roleRepository.findByName(erole).isEmpty())
				roleRepository.save(new RoleUser(erole));
		}
	}
	public void populateUsers() {
		UserCreateDTO userCreateDTO = new UserCreateDTO("duque@dolor.es", "cayetano", new BCryptPasswordEncoder().encode("1234"), "ADMIN","USER");
		userService.createUser(userCreateDTO);
	}
}
