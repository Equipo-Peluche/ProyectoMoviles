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
import com.apimovil.models.entities.TamanioPantalla;
import com.apimovil.models.filters.FilterScreenSize;
import com.apimovil.repositories.MovilRepository;
import com.apimovil.repositories.TamanioPantallaRepository;
import com.apimovil.utiles.DoubleIntervalo;

@SpringBootTest
class FilterScreenSizeTest {
	
	@Autowired
	MovilRepository movilRepository;
	@Autowired
	TamanioPantallaRepository pantallaRepository;

	@Test
	void test() {
		TamanioPantalla tamanioPantalla = new TamanioPantalla(7.6);
		TamanioPantalla tamanioPantalla1 = new TamanioPantalla(7.0);
		TamanioPantalla tamanioPantalla2 = new TamanioPantalla(5.8);
		
		pantallaRepository.saveAll(List.of(tamanioPantalla,tamanioPantalla1,tamanioPantalla2));
		
        Movil movil_1 = new Movil(null, null, null, tamanioPantalla, 128, 8, 231.4, 32.0, 4500, false, 359.99, LocalDate.now(), 122.3, 78.5 , 12.1, 0);
		Movil movil_2 = new Movil(null, null, null, tamanioPantalla1, 512, 12, 251.4, 102.0, 5500, true, 1199.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		Movil movil_3 = new Movil(null, null, null, tamanioPantalla2, 512, 12, 251.4, 102.0, 5500, true, 1199.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		movilRepository.saveAll(List.of(movil_1, movil_2, movil_3));
		
		MovilFilterRequestDTO request = new MovilFilterRequestDTO();
		DoubleIntervalo intervalo = new DoubleIntervalo(6.0, 10.0);
		request.setIntervaloTamanio(intervalo);
		
		FilterScreenSize filterScreenSize = new FilterScreenSize();
		List<Movil> listaFiltrada = filterScreenSize.filter(movilRepository.findAll(), request);
		
		assertEquals(2, listaFiltrada.size());
	}

}
