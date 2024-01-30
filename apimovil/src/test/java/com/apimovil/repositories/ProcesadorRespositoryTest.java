package com.apimovil.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.entities.Procesador;
import com.apimovil.repositories.ProcesadorRepository;

@SpringBootTest
class ProcesadorRespositoryTest {
 @Autowired
 ProcesadorRepository procesadorRepository;
 

 // si me funciona por separado esto es para que no se duplique
 	@BeforeEach
 	void test() {
 		procesadorRepository.deleteAll();
 	}
 
	@Test
	void testGigahercios() {
		Procesador procesador1 = new Procesador(3.8, "Procesador de alta velocidad");
		Procesador procesador2 = new Procesador(3.8, "Procesador de baja velocidad");
		Procesador procesador3= new Procesador(4.5, "Procesador de media velocidad");
		Procesador procesador4 = new Procesador(5.0, "Procesador de alta velocidad");

		procesadorRepository.save(procesador1);	
		procesadorRepository.save(procesador2);	
		procesadorRepository.save(procesador3);	
		procesadorRepository.save(procesador4);
		
		int expected=2;
		List<Procesador> pocesadorResultado = new ArrayList();
		pocesadorResultado = procesadorRepository.findByGigahercios(3.8);
		assertEquals(expected, pocesadorResultado.size());
	}
	
	@Test
	void testDescripcion() {
		Procesador procesador1 = new Procesador(3.8, "Procesador de alta velocidad");
		Procesador procesador2 = new Procesador(3.8, "Procesador de baja velocidad");
		Procesador procesador3= new Procesador(4.5, "Procesador de media velocidad");
		Procesador procesador4 = new Procesador(5.0, "Procesador de alta velocidad");

		procesadorRepository.save(procesador1);	
		procesadorRepository.save(procesador2);	
		procesadorRepository.save(procesador3);	
		procesadorRepository.save(procesador4);
		
	    int expected = 2;
	    List<Procesador> procesadoresResultado = new ArrayList();
	    procesadoresResultado = procesadorRepository.findByNombre("Procesador de alta velocidad");
	    assertEquals(expected, procesadoresResultado.size());	
	}
}
