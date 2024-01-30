package com.apimovil.test.repositories;

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

@SpringBootTest
class ProcesadorFilterTest {

	@Autowired
	MovilRepository mRepository;
	
	private List<IFilter> filters;
	private List<Movil> moviles;
	
	
	 public void testProcesadorFilter() {
	        // Crear algunos móviles para la prueba
	        TecnologiaPantalla tecnologiaPantalla = new TecnologiaPantalla();
	        Procesador procesadorA = new Procesador(2.0, "Ryzen 5");
	        Procesador procesadorB = new Procesador(3.0, "Intel core i5");
	        TamanioPantalla tamanioPantalla = new TamanioPantalla();

	        Movil movil_1 = new Movil(tecnologiaPantalla, null, procesadorA, tamanioPantalla, 128, 4, 150, 12, 4000, true, 500, LocalDate.now(), null, 100);
	        Movil movil_2 = new Movil(tecnologiaPantalla, null, procesadorB, tamanioPantalla, 256, 8, 180, 16, 5000, false, 700, LocalDate.now(), null, 150);
	        Movil movil_3 = new Movil(tecnologiaPantalla, null, procesadorA, tamanioPantalla, 64, 6, 160, 14, 4500, true, 600, LocalDate.now(), null, 120);

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
	        assertEquals("ProcesadorA", resultadoFiltro.get(0).getProcesador().getNombre());
	        assertEquals("ProcesadorA", resultadoFiltro.get(1).getProcesador().getNombre());
	    }
	}
