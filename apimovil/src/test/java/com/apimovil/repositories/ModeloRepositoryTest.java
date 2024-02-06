package com.apimovil.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.apimovil.components.Populate;
import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.Modelo;
import com.apimovil.services.MovilService;

@SpringBootTest
class ModeloRepositoryTest {
	@Autowired
	private ModeloRepository modeloRepository;
	
	@Autowired
	private MarcaRepository marcaRepository;

	@MockBean
	private MovilService movilService;
	private Populate populate;
	
	
	@BeforeEach
	void initial() {
		modeloRepository.deleteAll();
		marcaRepository.deleteAll();
	}

	@Test
	void test() {
		Marca iphone = new Marca("Iphone");
		Marca samsung = new Marca("Samsung");
		Marca xiaomi = new Marca("Xiaomi");
		
		marcaRepository.save(iphone);
		marcaRepository.save(samsung);
		marcaRepository.save(xiaomi);
		
		Modelo modelo1 = new Modelo("8",iphone);
		Modelo modelo3 = new Modelo("8 PLUS",iphone);
		Modelo modelo2 = new Modelo("GALAXY S8",samsung);
		Modelo modelo4 = new Modelo("REDMI NOTE 10",xiaomi);
		
		modeloRepository.save(modelo1);
		modeloRepository.save(modelo2);
		modeloRepository.save(modelo3);
		modeloRepository.save(modelo4);
		
		//Buscar by nombre
		int cantidadEsperada=1;
		List<Modelo> modelos = modeloRepository.findByNombre("8 PLUS");
		assertEquals(cantidadEsperada, modelos.size());
		
		//Buscar by id
		Modelo modelo= modeloRepository.findById(1l).get();
		assertNotNull(modelo);
		assertEquals("8", modelo.getNombre());
		 
		//Buscar by Marca
		cantidadEsperada=2;
		modelos= modeloRepository.findByMarca(iphone);
		assertEquals(cantidadEsperada,modelos.size());
		
		
	}
	@AfterEach
	void aftereach() {
		marcaRepository.deleteAll();
		modeloRepository.deleteAll();
	}
	

}
