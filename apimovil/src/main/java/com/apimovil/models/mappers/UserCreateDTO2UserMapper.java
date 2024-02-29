package com.apimovil.models.mappers;

import com.apimovil.models.dto.UserCreateDTO;
import com.apimovil.models.entities.mongo.UserEntity;

public class UserCreateDTO2UserMapper implements MyMapper<UserCreateDTO, UserEntity>{

	@Override
	public UserEntity map(UserCreateDTO t) {
		return new UserEntity(t.email(), t.username(), t.password());
	}

}
