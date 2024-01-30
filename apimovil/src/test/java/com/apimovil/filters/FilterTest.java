package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.TecnologiaPantalla;
import com.apimovil.models.filters.FilterRam;
import com.apimovil.models.filters.FilterTecnologiaPantalla;
import com.apimovil.models.filters.IFilter;
import com.apimovil.models.filters.PrecioFilter;
import com.apimovil.repositories.MovilRepository;
import com.apimovil.repositories.TecnologiaPantallaRepository;
import com.apimovil.utiles.DoubleIntervalo;

@SpringBootTest
class FilterTest {

	@Autowired
	MovilRepository mRepository;
	
	@Autowired
	TecnologiaPantallaRepository tecnologiaPantallaRepository;
	
	private List<IFilter> filters;
	private List<Movil> moviles;
	
	@Test
	void test() {
		
		filters = new ArrayList<>();
		
		filters.add(new FilterRam());
		filters.add(new PrecioFilter());
		filters.add(new FilterTecnologiaPantalla());
		
		//mRepository.save(new Movil(128, 8, 213.2, 33, 4100, true, 313, LocalDate.now(), null));
		//mRepository.save(new Movil(64, 4, 177.2, 33, 3090, false, 199, LocalDate.now(), null));
		//mRepository.save(new Movil(256, 12, 256.2, 33, 5900, true, 414, LocalDate.now(), null));
		
		TecnologiaPantalla tecnologia = new TecnologiaPantalla("OLED");
		TecnologiaPantalla tecnologia2 = new TecnologiaPantalla("LED");
		tecnologiaPantallaRepository.save(tecnologia);
		tecnologiaPantallaRepository.save(tecnologia2);
		
		Movil samsungMovil = new Movil(tecnologia, null, null, null, 128, 8, 231.4, 32.0, 4500, false, 359.99, LocalDate.now(), 122.3, 78.5 , 12.1, 0);
		Movil iphoneMovil = new Movil(tecnologia2, null, null, null, 512, 12, 251.4, 102.0, 5500, true, 299.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
		mRepository.save(samsungMovil);
		mRepository.save(iphoneMovil);
		
		moviles = mRepository.findAll();
		
		MovilFilterRequestDTO movilRequestDTO = new MovilFilterRequestDTO();
		
		movilRequestDTO.setIntervaloPrecio(new DoubleIntervalo(200.0,400.0));
		movilRequestDTO.setRam(5);
		movilRequestDTO.setTecnologiaPantalla("OLED");
		
		for (IFilter filter: filters) {
			moviles=filter.filter(moviles, movilRequestDTO);
		}
		Integer expected=1;
		assertEquals(expected, moviles.size());
		
		
//		movilRequestDTO = new MovilFilterRequestDTO();
//		for (IFilter filter: filters) {
//			moviles=filter.filter(moviles, movilRequestDTO);
//		}
//		
//		assertEquals(expected, moviles.size());
		
		
		
	}

}
