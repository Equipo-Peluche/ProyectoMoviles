package com.apimovil;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.Dimension;
import com.apimovil.models.entities.Movil;
import com.apimovil.repositories.DimensionRepository;
import com.apimovil.repositories.MovilRepository;

@SpringBootTest
class ApimovilApplicationTests {
	
	@Autowired
	MovilRepository mRepository;
	
	@Autowired
	DimensionRepository dRepository;

	@Test
	void contextLoads() {
		Dimension prueba1 = new Dimension( 55, 440, 34);
		Dimension prueba2 = new Dimension( 44, 440, 34);
		Dimension prueba3 = new Dimension( 123, 440, 34);
		
		dRepository.save(prueba1);
		dRepository.save(prueba2);
		dRepository.save(prueba3);
		
		mRepository.save(new Movil(128, 8, 213.2, 33, 4100, true, 313, LocalDate.now(), prueba1));
		mRepository.save(new Movil(64, 4, 177.2, 33, 3090, false, 199, LocalDate.now(), prueba2));
		mRepository.save(new Movil(256, 12, 256.2, 33, 5900, true, 414, LocalDate.now(), prueba3));
		
		assertEquals(3, mRepository.findAll().size());
		assertEquals(2, mRepository.findByBateriaGreaterThanEqual(4000).size());
		assertEquals(1, mRepository.findByDimensiones_AltoGreaterThanEqual(55).size());
		
		
	}

}
