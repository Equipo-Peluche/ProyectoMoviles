package com.apimovil.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.om.MovilOM;
import com.apimovil.repositories.MovilRepository;
import com.apimovil.utiles.DoubleIntervalo;

@SpringBootTest
class ServiceMockTest {

	@MockBean
	MovilRepository movilRepository;
	
	@Autowired
	@InjectMocks
	MovilService movilService;
	
	MovilFilterRequestDTO movilFilterRequestDTO;
	MovilOM movilOM;
	List<Movil> moviles;
	
	@BeforeEach
	void before() {
		movilFilterRequestDTO = new MovilFilterRequestDTO();
		movilOM = new MovilOM();
		moviles = new ArrayList<>();
	}
	
	@Test
	void test() {
		moviles.addAll(movilOM.getData());
		when(movilRepository.findAll()).thenReturn(moviles);
		
//		Filtrar por Precio
		DoubleIntervalo precio  = new DoubleIntervalo(1.0, 200.0);
		movilFilterRequestDTO.setIntervaloPrecio(precio);
		int expected = 2;
		assertEquals(expected, movilService.getMovilesFilter(movilFilterRequestDTO).size());
		
//		Filtrar por Precio
		precio.setNumeroMax(1200.0);
		movilFilterRequestDTO.setIntervaloPrecio(precio);
		int expected2 = 6;
		assertEquals(expected2, movilService.getMovilesFilter(movilFilterRequestDTO).size());

//		Filtrar por Precio y Modelo
		movilFilterRequestDTO.setModelo("15 Pro max");
		int expected3 = 1;
		assertEquals(expected3, movilService.getMovilesFilter(movilFilterRequestDTO).size());


	}

}
