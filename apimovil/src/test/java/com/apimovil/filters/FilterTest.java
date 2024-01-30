package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.filters.FilterRam;
import com.apimovil.models.filters.IFilter;
import com.apimovil.models.filters.PrecioFilter;
import com.apimovil.repositories.MovilRepository;
import com.apimovil.utiles.DoubleIntervalo;

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
		filters.add(new PrecioFilter());
		
		mRepository.save(new Movil(null, null, null, null, 128, 8, 231.4, 32.0, 4500, false, 359.99, LocalDate.now(), 122.3, 78.5 , 12.1, 0));

		moviles = mRepository.findAll();
		
		MovilFilterRequestDTO movilRequestDTO = new MovilFilterRequestDTO();
		
		movilRequestDTO.setIntervaloPrecio(new DoubleIntervalo(200.0,400.0));
		movilRequestDTO.setRam(5);
		for (IFilter filter: filters) {
			moviles=filter.filter(moviles, movilRequestDTO);
		}
		Integer expected=1;
		assertEquals(expected, moviles.size());
		
		
		movilRequestDTO = new MovilFilterRequestDTO();
		for (IFilter filter: filters) {
			moviles=filter.filter(moviles, movilRequestDTO);
		}
		
		assertEquals(expected, moviles.size());
		
		
		
	}

}
