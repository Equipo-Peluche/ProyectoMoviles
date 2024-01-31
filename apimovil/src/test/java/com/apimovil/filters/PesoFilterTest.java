package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.filters.PesoFilter;
import com.apimovil.repositories.MovilRepository;
import com.apimovil.utiles.DoubleIntervalo;

@SpringBootTest
class PesoFilterTest {

	@Autowired
	MovilRepository mRepository;

	@Test
	void testPesoFilter() {
		
		// Crear tres móviles con diferentes procesadores y guardarlos en la base de datos
        Movil movil_1 = new Movil(null, null, null, null, 128, 8, 140.0, 32.0, 4500, true, 359.99, LocalDate.now(), 122.3, 78.5 , 12.1, 0);
		Movil movil_2 = new Movil(null, null, null, null, 512, 12, 180.0, 102.0, 5500, false, 1199.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		Movil movil_3 = new Movil(null, null, null, null, 512, 12, 160.0, 102.0, 5500, true, 1199.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		
        // Guardar los móviles en la base de datos
		mRepository.saveAll(List.of(movil_1, movil_2, movil_3));
		
		// Crear una solicitud de filtro con un intervalo de peso
        MovilFilterRequestDTO request = new MovilFilterRequestDTO();
        DoubleIntervalo intervaloPeso = new DoubleIntervalo(150.0, 200.0);
		request.setIntervaloPeso(intervaloPeso);
		
		// Aplicar el filtro
        PesoFilter pesoFilter = new PesoFilter();
        List<Movil> resultadoFiltro = pesoFilter.filter(mRepository.findAll(), request);
        
        // Verificar que el resultado sea el esperado
        assertEquals(2, resultadoFiltro.size());
        assertEquals(180, resultadoFiltro.get(0).getPeso());
        assertEquals(160, resultadoFiltro.get(1).getPeso());   
	}
	
	@AfterEach
	void afterEach() {
		mRepository.deleteAll();
	}

}
