package com.apimovil.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.entities.TamanioPantalla;

@SpringBootTest
class TamanioPantallaRepositoryTest {

	@Autowired
	TamanioPantallaRepository pantallaRepository;
	
	@BeforeEach
	void beforeEach() {
		List<TamanioPantalla> listaTamaniosPantalla = new ArrayList<>();
		
		listaTamaniosPantalla.add( new TamanioPantalla(7.0));
		listaTamaniosPantalla.add( new TamanioPantalla(7.3));
		listaTamaniosPantalla.add( new TamanioPantalla(4.0));
		listaTamaniosPantalla.add( new TamanioPantalla(6.7));
		listaTamaniosPantalla.add( new TamanioPantalla(6.1));
		listaTamaniosPantalla.add( new TamanioPantalla(5.8));
		listaTamaniosPantalla.add( new TamanioPantalla(8.0));
		
		pantallaRepository.saveAll(listaTamaniosPantalla);
	}
	@Test
	void test() {
		//Filtrado dos tamños
		int filtroEntrePulgadas = 4;
		Double pulgadaMenor = 5.0 , pulgadaMayor = 7.1;
		assertEquals(filtroEntrePulgadas, pantallaRepository.findAllByPulgadasBetween(pulgadaMenor, pulgadaMayor).size());
		
		//Filtrado mayor que parametro
		int filtroPulgadasMayor = 3;
		Double pulgadaEntrada = 6.9;
		assertEquals(filtroPulgadasMayor, pantallaRepository.findAllByPulgadasGreaterThan(pulgadaEntrada).size());
		
		//Filtrado menor que parametro
		int filtroPulgadasMenor = 2;
		Double pulgadaEntrada1 = 6.0;
		assertEquals(filtroPulgadasMenor, pantallaRepository.findAllByPulgadasLessThan(pulgadaEntrada1).size());
	
	}
	@AfterEach
	void aftereach() {
		pantallaRepository.deleteAll();
	}

}
