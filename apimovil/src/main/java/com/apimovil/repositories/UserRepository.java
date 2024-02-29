package com.apimovil.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apimovil.models.entities.mongo.UserEntity;


public interface UserRepository extends MongoRepository<UserEntity, String> {
	Optional<UserEntity> findByUsername(String username);

	void deleteByUsername(String username);
//	ByUsername(String username);
	
	//opcionalmente con query
//	@Query("select u from UserEntity u where u.username=?1")
//	Optional<UserEntity> getName(String username);
}
