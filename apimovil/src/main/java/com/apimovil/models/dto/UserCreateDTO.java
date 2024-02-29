package com.apimovil.models.dto;

public record UserCreateDTO(
		String email,
		String username,
		String password,
		String... roles
		){}
