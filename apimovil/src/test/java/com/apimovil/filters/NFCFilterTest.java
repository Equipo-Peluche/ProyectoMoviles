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
import com.apimovil.models.filters.NFCFilter;
import com.apimovil.repositories.MovilRepository;
@SpringBootTest
class NFCFilterTest {

	@Autowired
	MovilRepository mRepository;
	
	@Test
	void testNFCFilter() {
		
		// Crear tres móviles con diferentes procesadores y guardarlos en la base de datos
        Movil movil_1 = new Movil(null, null, null, null, 128, 8, 140.0, 32.0, 4500, false, 359.99, LocalDate.now(), 122.3, 78.5 , 12.1, 0);
		Movil movil_2 = new Movil(null, null, null, null, 512, 12, 180.0, 102.0, 5500, true, 1199.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		Movil movil_3 = new Movil(null, null, null, null, 512, 12, 160.0, 102.0, 5500, true, 1199.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		
        // Guardar los móviles en la base de datos
		mRepository.saveAll(List.of(movil_1, movil_2, movil_3));
		
        // Crear una solicitud de filtro con NFC = true y con NFC = false
        MovilFilterRequestDTO requestTrue = new MovilFilterRequestDTO();
        requestTrue.setNfc(true);
        MovilFilterRequestDTO requestFalse = new MovilFilterRequestDTO();
        requestFalse.setNfc(false);
        
        // Aplicar el filtro para NFC = true y con NFC = false
        NFCFilter nfcFilterTrue = new NFCFilter();
        List<Movil> resultadoFiltroTrue = nfcFilterTrue.filter(mRepository.findAll(), requestTrue);

        NFCFilter nfcFilterFalse = new NFCFilter();
        List<Movil> resultadoFiltroFalse = nfcFilterFalse.filter(mRepository.findAll(), requestFalse);

        // Verificar que los resultados sean los esperados
        assertEquals(2, resultadoFiltroTrue.size());
        assertEquals(1, resultadoFiltroFalse.size());
	}
	
	@AfterEach
	void afterEach() {
		mRepository.deleteAll();
	}

}
