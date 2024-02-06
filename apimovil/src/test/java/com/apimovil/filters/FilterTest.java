package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.Procesador;
import com.apimovil.models.entities.TamanioPantalla;
import com.apimovil.models.entities.TecnologiaPantalla;
import com.apimovil.models.filters.FilterRam;
import com.apimovil.models.filters.FilterTecnologiaPantalla;
import com.apimovil.models.filters.IFilter;
import com.apimovil.models.filters.PrecioFilter;
import com.apimovil.models.om.MarcaOM;
import com.apimovil.models.om.ModeloOM;
import com.apimovil.models.om.ProcesadorOM;
import com.apimovil.models.om.TamanioPantallaOM;
import com.apimovil.repositories.MarcaRepository;
import com.apimovil.repositories.ModeloRepository;
import com.apimovil.repositories.MovilRepository;
import com.apimovil.repositories.ProcesadorRepository;
import com.apimovil.repositories.TamanioPantallaRepository;
import com.apimovil.repositories.TecnologiaPantallaRepository;
import com.apimovil.utiles.DoubleIntervalo;

@SpringBootTest
class FilterTest {

	@Autowired
	MovilRepository mRepository;

	@Autowired
	TecnologiaPantallaRepository tecnologiaPantallaRepository;

	@Autowired
	ModeloRepository modeloRepository;

	@Autowired
	MarcaRepository marcaRepository;

	@Autowired
	ProcesadorRepository procesadorRepository;
	
	@Autowired
	TamanioPantallaRepository pantallaRepository;

	MarcaOM marcaOM = new MarcaOM();
	ModeloOM modeloOM;
	ProcesadorOM procesadorOM = new ProcesadorOM();
	TamanioPantallaOM tamanioPantallaOM = new TamanioPantallaOM();

	private List<IFilter> filters;
	private List<Movil> moviles;

	@Test
	void test() {

		filters = new ArrayList<>();

		filters.add(new FilterRam());
		filters.add(new PrecioFilter());
		filters.add(new FilterTecnologiaPantalla());

		TecnologiaPantalla tecnologia = new TecnologiaPantalla("OLED");
		TecnologiaPantalla tecnologia2 = new TecnologiaPantalla("LED");
		tecnologiaPantallaRepository.save(tecnologia);
		tecnologiaPantallaRepository.save(tecnologia2);

		Marca marca1 = new Marca("Marca1");
		Marca marca2 = new Marca("Marca2");
		marcaRepository.save(marca1);
		marcaRepository.save(marca2);

		Modelo modelo1 = new Modelo("Modelo1", marca1);
		Modelo modelo2 = new Modelo("Modelo2", marca2);
		modeloRepository.save(modelo1);
		modeloRepository.save(modelo2);

		Procesador procesador1 = new Procesador(1, "Procesador1");
		Procesador procesador2 = new Procesador(1, "Procesador2");
		procesadorRepository.save(procesador1);
		procesadorRepository.save(procesador2);
		
		TamanioPantalla tamanioPantalla1 = new TamanioPantalla(2.0);
		TamanioPantalla tamanioPantalla2 = new TamanioPantalla(2.0);
		pantallaRepository.save(tamanioPantalla1);
		pantallaRepository.save(tamanioPantalla2);

		Movil samsungMovil = new Movil(tecnologia, modelo1, procesador1, tamanioPantalla1, 128, 8,
				231.4, 32.0, 4500, false, 359.99, LocalDate.now(), 122.3, 78.5, 12.1, 0);
		Movil iphoneMovil = new Movil(tecnologia2, modelo2, procesador2, tamanioPantalla2, 512, 12,
				251.4, 102.0, 5500, true, 299.99, LocalDate.now(), 152.3, 89.5, 9.1, 0);

		mRepository.save(samsungMovil);
		mRepository.save(iphoneMovil);

		moviles = mRepository.findAll();

		MovilFilterRequestDTO movilRequestDTO = new MovilFilterRequestDTO();

		movilRequestDTO.setIntervaloPrecio(new DoubleIntervalo(200.0, 400.0));
		movilRequestDTO.setRam(5);
		movilRequestDTO.setTecnologiaPantalla("OLED");

		for (IFilter filter : filters) {
			moviles = filter.filter(moviles, movilRequestDTO);
		}
		Integer expected = 1;
		assertEquals(expected, moviles.size());

	}
	
	@BeforeEach
	void before() {
		tecnologiaPantallaRepository.deleteAll();
		modeloRepository.deleteAll();
		marcaRepository.deleteAll();
		procesadorRepository.deleteAll();
		pantallaRepository.deleteAll();
		mRepository.deleteAll();
	}

	@AfterEach
	void afterEach() {
		tecnologiaPantallaRepository.deleteAll();
		modeloRepository.deleteAll();
		marcaRepository.deleteAll();
		procesadorRepository.deleteAll();
		pantallaRepository.deleteAll();
		mRepository.deleteAll();
	}

}
