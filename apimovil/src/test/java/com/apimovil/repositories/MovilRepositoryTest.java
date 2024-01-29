package com.apimovil.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.entities.Movil;
@SpringBootTest
class MovilRepositoryTest {
	@Autowired
	MovilRepository mRepository;
	@Test
	void test() {
		mRepository.save(new Movil(128, 8, 213.2, 33, 4100, true, 313, LocalDate.now(), null));
		mRepository.save(new Movil(64, 4, 177.2, 33, 3090, false, 199, LocalDate.now(), null));
		mRepository.save(new Movil(256, 12, 256.2, 33, 5900, true, 414, LocalDate.now(), null));
	}

}
