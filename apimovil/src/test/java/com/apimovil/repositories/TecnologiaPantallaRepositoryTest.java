package com.apimovil.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.TecnologiaPantalla;

@SpringBootTest
class TecnologiaPantallaRepositoryTest {

	@Autowired
	MovilRepository movilRepository;
	@Autowired
	TecnologiaPantallaRepository tecnologiaPantallaRepository;
	
	@Test
	void test() {
		TecnologiaPantalla tecnologia1 = new TecnologiaPantalla("LCD");
		TecnologiaPantalla tecnologia2 = new TecnologiaPantalla("LED");
		TecnologiaPantalla tecnologia3 = new TecnologiaPantalla("OLED");
		TecnologiaPantalla tecnologia4 = new TecnologiaPantalla("AMOLED");
		
		tecnologiaPantallaRepository.save(tecnologia1);
		tecnologiaPantallaRepository.save(tecnologia2);
		tecnologiaPantallaRepository.save(tecnologia3);
		tecnologiaPantallaRepository.save(tecnologia4);

//		Movil movil1 = new Movil(tecnologia1);
//		Movil movil2 = new Movil(tecnologia2);
//		Movil movil3 = new Movil(tecnologia2);
//		tecnologia1.addMovil(movil1);
//		tecnologia2.addMovil(movil2);
//		tecnologia2.addMovil(movil3);

//		movilRepository.save(movil1);
//		movilRepository.save(movil2);
		
//		FindById
		Optional<TecnologiaPantalla> byId1 = tecnologiaPantallaRepository.findById(1l);
		assertNotNull(byId1);
		assertEquals("LCD", byId1.get().getNombre());
		
//		FindByNombre
		Long id3 = tecnologiaPantallaRepository.findById(3l).get().getId();
		assertEquals(id3, tecnologiaPantallaRepository.findByNombre("OLED"));
		
		
		
//		Coger Lista de moviles por tecnologia de Pantalla
//		ERROR DE RECURSIVIDAD
//		tecnologiaPantallaRepository.findById(2L).ifPresent((tec)->{
//			System.out.println("hola");
//			tec.getMoviles()
//			.forEach(movil-> System.out.println(movil.toString()));
//		});
	
		
		
	}

}
