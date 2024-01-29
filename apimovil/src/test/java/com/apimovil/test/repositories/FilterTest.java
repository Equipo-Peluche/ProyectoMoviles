package com.apimovil.test.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.filters.FilterRam;
import com.apimovil.models.filters.IFilter;
import com.apimovil.repositories.MovilRepository;

@SpringBootTest
class FilterTest {

	@Autowired
	MovilRepository mRepository;
	
	private List<IFilter> filters;
	private List<Movil> moviles;
	
	@Test
	void test() {
		
		filters = new ArrayList<>();
		
		filters.add(new FilterRam());
		
		mRepository.save(new Movil(128, 8, 213.2, 33, 4100, true, 313, LocalDate.now(), null));
		mRepository.save(new Movil(64, 4, 177.2, 33, 3090, false, 199, LocalDate.now(), null));
		mRepository.save(new Movil(256, 12, 256.2, 33, 5900, true, 414, LocalDate.now(), null));
		
		moviles = mRepository.findAll();
		
		MovilRequestDTO movilRequestDTO = new MovilRequestDTO();
		movilRequestDTO.setNombre("algo");
		movilRequestDTO.setRam(5);
		for (IFilter filter: filters) {
			moviles=filter.filter(moviles, movilRequestDTO);
		}
		
		moviles.forEach(m -> System.err.println(m));
		
		
	}

}
