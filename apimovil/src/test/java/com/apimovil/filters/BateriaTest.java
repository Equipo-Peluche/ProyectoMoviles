package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.filters.FilterBateria;
import com.apimovil.models.filters.IFilter;
import com.apimovil.repositories.MovilRepository;

@SpringBootTest
class BateriaTest {

	@Autowired
	MovilRepository mRepository;
	
	private List<IFilter> filters;
	private List<Movil> moviles;
	
	@Test
	void test() {
		filters = new ArrayList<>();
		filters.add(new FilterBateria());
		
		Movil samsungMovil = new Movil(null, null, null, null, 128, 8, 231.4, 32.0, 4500, false, 359.99, LocalDate.now(), 122.3, 78.5 , 12.1, 0);
		Movil iphoneMovil = new Movil(null, null, null, null, 512, 12, 251.4, 102.0, 5500, true, 299.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		Movil movilChino = new Movil(null, null, null, null, 512, 12, 251.4, 102.0, 4700, true, 299.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		mRepository.save(samsungMovil);
		mRepository.save(iphoneMovil);
		mRepository.save(movilChino);

		moviles = mRepository.findAll();
		
		MovilFilterRequestDTO movilRequestDTO = new MovilFilterRequestDTO();
		
		movilRequestDTO.setBateria(4700);
		
		for (IFilter filter: filters) {
			moviles=filter.filter(moviles, movilRequestDTO);
		}
		Integer expected=2;
		assertEquals(expected, moviles.size());

		
	}
	
	@AfterEach
	void test2() {
		mRepository.deleteAll();

	}

}
