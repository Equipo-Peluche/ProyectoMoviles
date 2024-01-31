package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.Procesador;
import com.apimovil.models.entities.TamanioPantalla;
import com.apimovil.models.entities.TecnologiaPantalla;
import com.apimovil.models.filters.IFilter;
import com.apimovil.models.filters.ProcesadorFilter;
import com.apimovil.repositories.MovilRepository;
import com.apimovil.repositories.ProcesadorRepository;

@SpringBootTest
class ProcesadorFilterTest {

	@Autowired
	MovilRepository mRepository;
	@Autowired
	ProcesadorRepository procesadorRepository;
		
	@Test
	 public void testProcesadorFilter() {
	        // Crear algunos procesadores para la prueba
	        Procesador procesadorA = new Procesador(2.0, "Ryzen 5");
	        Procesador procesadorB = new Procesador(3.0, "Intel core i5");
	        
	        procesadorRepository.saveAll(List.of(procesadorA,procesadorB));
	        

	        // Crear tres móviles con diferentes procesadores y guardarlos en la base de datos
	        Movil movil_1 = new Movil(null, null, procesadorB, null, 128, 8, 231.4, 32.0, 4500, false, 359.99, LocalDate.now(), 122.3, 78.5 , 12.1, 0);
			Movil movil_2 = new Movil(null, null, procesadorA, null, 512, 12, 251.4, 102.0, 5500, true, 1199.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
			Movil movil_3 = new Movil(null, null, procesadorA, null, 512, 12, 251.4, 102.0, 5500, true, 1199.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);

	        // Guardar los móviles en la base de datos
	        mRepository.saveAll(List.of(movil_1, movil_2, movil_3));

	        // Crear una solicitud de filtro
	        MovilFilterRequestDTO request = new MovilFilterRequestDTO();
	        request.setProcesador("Ryzen 5");

	        // Aplicar el filtro
	        ProcesadorFilter procesadorFilter = new ProcesadorFilter();
	        List<Movil> resultadoFiltro = procesadorFilter.filter(mRepository.findAll(), request);

	        // Verificar que el resultado sea el esperado
	        assertEquals(2, resultadoFiltro.size());
	        assertEquals("Ryzen 5", resultadoFiltro.get(0).getProcesador().getNombre());
	        assertEquals("Ryzen 5", resultadoFiltro.get(1).getProcesador().getNombre());
	    }
	}
