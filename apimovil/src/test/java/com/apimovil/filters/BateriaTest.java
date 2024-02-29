package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.Procesador;
import com.apimovil.models.entities.TamanioPantalla;
import com.apimovil.models.entities.TecnologiaPantalla;
import com.apimovil.models.filters.FilterBateria;
import com.apimovil.models.filters.IFilter;
import com.apimovil.models.om.MarcaOM;
import com.apimovil.models.om.ModeloOM;
import com.apimovil.models.om.ProcesadorOM;
import com.apimovil.models.om.TamanioPantallaOM;
import com.apimovil.models.om.TecnologiaPantallaOM;
import com.apimovil.repositories.MovilRepository;

@SpringBootTest
class BateriaTest {

	
	private List<IFilter> filters;
	private List<Movil> moviles;
	
	@BeforeEach
	void beforeEach() {
		filters = new ArrayList<>();
		moviles= new ArrayList<>();
	}
	
	@Test
	void test() {
		
		filters.add(new FilterBateria());
		
		
		TecnologiaPantalla tecnologiaPantallaEjemplo = new TecnologiaPantallaOM().getData().get(0);
		TamanioPantalla TamanioEjemplo = new TamanioPantallaOM().getData().get(0);
		Procesador procesadorEjemplo = new ProcesadorOM().getData().get(0);
		
		Modelo modeloEjemplo1 = new ModeloOM().getData().get(0);
		Modelo modeloEjemplo2 = new ModeloOM().getData().get(0);
		Modelo modeloEjemplo3 = new ModeloOM().getData().get(0);
		
		
		
		Movil samsungMovil = new Movil(tecnologiaPantallaEjemplo, modeloEjemplo1, procesadorEjemplo, TamanioEjemplo, 128, 8, 231.4, 32.0, 4500, false, 359.99, LocalDate.now(), 122.3, 78.5 , 12.1, 0);
		Movil iphoneMovil = new Movil(tecnologiaPantallaEjemplo, modeloEjemplo2, procesadorEjemplo, TamanioEjemplo, 512, 12, 251.4, 102.0, 5500, true, 299.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		Movil movilChino = new Movil(tecnologiaPantallaEjemplo, modeloEjemplo3, procesadorEjemplo, TamanioEjemplo, 512, 12, 251.4, 102.0, 4700, true, 299.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		moviles.add(samsungMovil);
		moviles.add(iphoneMovil);
		moviles.add(movilChino);

		
		MovilFilterRequestDTO movilRequestDTO = new MovilFilterRequestDTO();
		
		movilRequestDTO.setBateria(4700);
		
		for (IFilter filter: filters) {
			moviles=filter.filter(moviles, movilRequestDTO);
		}
		Integer expected=2;
		assertEquals(expected, moviles.size());

		
	}


}
