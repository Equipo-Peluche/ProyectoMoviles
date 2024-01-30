package com.apimovil.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.Dimension;
import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.Procesador;
@SpringBootTest
class MovilRepositoryTest {
	
	@Autowired
	MovilRepository movilRepository;
	@Autowired
	DimensionRepository dimensionRepository;
	@Autowired
	ModeloRepository modeloRepository;
	@Autowired
	ProcesadorRepository procesadorRepository;
	@Autowired
	MarcaRepository marcaRepository;
	
	
	@Test
	void test() {
		
		//INICIANDO PROCESADORES
		procesadorRepository.save(new Procesador(2.3, "Snapdragon 3100"));
		procesadorRepository.save(new Procesador(5.4, "Snapdragon 3700"));
		
		//INICIANDO DIMENSIONES
		dimensionRepository.save(new Dimension(22.4, 155.3, 111.3));
		dimensionRepository.save(new Dimension(32.4, 155.3, 111.3));
		
		//INICIANDO MARCAS
		Marca iphone = new Marca("iPhone");
		Marca samsung = new Marca("Samsung");
		marcaRepository.save(iphone);
		marcaRepository.save(samsung);
		
		//INICIANDO MODELOS
		modeloRepository.save(new Modelo("s6", samsung));
		modeloRepository.save(new Modelo("8 plus", iphone));
	}

}
