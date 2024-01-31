package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.filters.FilterModelo;
import com.apimovil.repositories.ModeloRepository;
import com.apimovil.repositories.MovilRepository;

@SpringBootTest
class FilterModeloTest {

	@Autowired
	MovilRepository movilRepository;
	@Autowired
	ModeloRepository modeloRepository;
	
	@Test
	void test() {
		Modelo modelo = new Modelo("Galaxy", null);
		Modelo modelo1 = new Modelo("S20", null);
		Modelo modelo2 = new Modelo("Redmid", null);

		modeloRepository.saveAll(List.of(modelo, modelo1, modelo2));

		Movil movil_1 = new Movil(null, modelo, null, null, 128, 8, 231.4, 32.0, 4500, false, 359.99, LocalDate.now(),
				122.3, 78.5, 12.1, 0);
		Movil movil_2 = new Movil(null, modelo1, null, null, 512, 12, 251.4, 102.0, 5500, true, 1199.99,
				LocalDate.now(), 152.3, 89.5, 9.1, 0);
		Movil movil_3 = new Movil(null, modelo2, null, null, 512, 12, 251.4, 102.0, 5500, true, 1199.99,
				LocalDate.now(), 152.3, 89.5, 9.1, 0);

		movilRepository.saveAll(List.of(movil_1, movil_2, movil_3));

		MovilFilterRequestDTO request = new MovilFilterRequestDTO();
		request.setModelo("S20");

		FilterModelo filterModelo = new FilterModelo();
		System.err.println("hola");
		List<Movil> moviles = movilRepository.findAll();
		System.err.println("hola despues");
		List<Movil> movilesFiltrados = filterModelo.filter(moviles, request);
		assertEquals(1, movilesFiltrados.size());
		assertEquals("S20", movilesFiltrados.get(0).getNombreModelo());

	}
	@AfterEach
	void afterEach() {
		movilRepository.deleteAll();
		modeloRepository.deleteAll();

	}

}
