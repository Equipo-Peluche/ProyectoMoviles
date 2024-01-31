package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.filters.FilterCamara;
import com.apimovil.repositories.MovilRepository;

@SpringBootTest
class FilterCamaraTest {

	@Autowired
	MovilRepository movilRepository;
	@Test
	void test() {
		
        Movil movil_1 = new Movil(null, null, null, null, 128, 8, 231.4, 32.0, 4500, false, 359.99, LocalDate.now(), 122.3, 78.5 , 12.1, 0);
		Movil movil_2 = new Movil(null, null, null, null, 512, 12, 251.4, 102.0, 5500, true, 1199.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		Movil movil_3 = new Movil(null, null, null, null, 512, 12, 251.4, 102.0, 5500, true, 1199.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		movilRepository.saveAll(List.of(movil_1, movil_2, movil_3));
	
		MovilFilterRequestDTO requestDTO = new MovilFilterRequestDTO();
		requestDTO.setCamara(50.0);
		
		FilterCamara filterCamara = new FilterCamara();
		List<Movil> movilesFiltrados = filterCamara.filter(movilRepository.findAll(), requestDTO);
		assertEquals(2, movilesFiltrados.size());
	}

}
