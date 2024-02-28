package com.apimovil.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.apimovil.models.ERole;
import com.apimovil.models.entities.mongo.RoleUser;
import com.apimovil.models.entities.mongo.User;

@SpringBootTest
class UserRepositoryTest {

	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Test
	void test() {
		mongoTemplate.getCollection("roles").drop();
		mongoTemplate.getCollection("users").drop();
		roleRepository.save(new RoleUser(ERole.ADMIN));
		userRepository.save(new User("Felix@gmail.com","Felix","1234"));
		userRepository.save(new User("Jose@gmail.com","Jose","4321"));
	}

}
