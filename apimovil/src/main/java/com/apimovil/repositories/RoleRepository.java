package com.apimovil.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.apimovil.models.ERole;
import com.apimovil.models.entities.mongo.RoleUser;

public interface RoleRepository extends MongoRepository<RoleUser, String> {

	public Optional<RoleUser> findByName(ERole erole);
}
