package com.apimovil.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.Dimension;
import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.Procesador;
import com.apimovil.models.entities.TamanioPantalla;
import com.apimovil.models.entities.TecnologiaPantalla;
@SpringBootTest
class MovilRepositoryTest {
	
	@Autowired
	TecnologiaPantallaRepository tecnologiaPantallaRepository;
	@Autowired
	MovilRepository movilRepository;
	@Autowired
	DimensionRepository dimensionRepository;
	@Autowired
	ModeloRepository modeloRepository;
	@Autowired
	ProcesadorRepository procesadorRepository;
	@Autowired
	MarcaRepository marcaRepository;
	@Autowired
	TamanioPantallaRepository tamanioPantallaRepository;
	
	@Test
	void test() {
		
		//INICIANDO PROCESADORES
		Procesador snapdragon = new Procesador(2.3, "Snapdragon 3100");
		Procesador m2 = new Procesador(5.4, "Apple M2");
		procesadorRepository.save(snapdragon);
		procesadorRepository.save(m2);
		
		//INICIANDO DIMENSIONES
		Dimension dimension1 = new Dimension(22.4, 155.3, 111.3);
		Dimension dimension2 = new Dimension(32.4, 313.3, 151.3);
		
		dimensionRepository.save(dimension1);
		dimensionRepository.save(dimension2);
		
		//INICIANDO MARCAS
		Marca iphoneMarca = new Marca("iPhone");
		Marca samsungMarca = new Marca("Samsung");
		marcaRepository.save(iphoneMarca);
		marcaRepository.save(samsungMarca);
		
		//INICIANDO MODELOS
		Modelo samsungModelo = new Modelo("s6", samsungMarca);
		Modelo samsungModelo2 = new Modelo("s7", samsungMarca);
		Modelo iphoneModelo = new Modelo("8 plus", iphoneMarca);
		modeloRepository.save(iphoneModelo);
		modeloRepository.save(samsungModelo);
		
		//INICIANDO TECNOLOGIAS DE PANTALLA
		TecnologiaPantalla oled = new TecnologiaPantalla("OLED");
		TecnologiaPantalla lcd = new TecnologiaPantalla("LCD");
		tecnologiaPantallaRepository.save(oled);
		tecnologiaPantallaRepository.save(lcd);
		
		//INICIANDO TAMAÑOS PANTALLA
		
		TamanioPantalla tamanio1 = new TamanioPantalla(6.33);
		TamanioPantalla tamanio2 = new TamanioPantalla(5.0);
		tamanioPantallaRepository.save(tamanio1);
		tamanioPantallaRepository.save(tamanio2);
		
		
		Movil samsungMovil = new Movil(lcd, samsungModelo, snapdragon, tamanio1, 128, 8, 231.4, 32.0, 4500, false, 359.99, LocalDate.now(), 122.3, 78.5 , 12.1, 0);
//		Movil samsungMovil2 = new Movil(lcd, samsungModelo2, snapdragon, tamanio1, 64, 8, 231.4, 32.0, 4500, false, 359.99, LocalDate.now(), 122.3, 78.5 , 12.1, 0);
		movilRepository.save(samsungMovil);
		Movil iphoneMovil = new Movil(lcd, iphoneModelo, snapdragon, tamanio2, 512, 12, 251.4, 102.0, 5500, true, 1199.99, LocalDate.now(), 152.3, 89.5 , 9.1, 0);
//		movilRepository.save(samsungMovil2);
		movilRepository.save(iphoneMovil);

		assertEquals(2, movilRepository.findAll().size());
		assertEquals(2, modeloRepository.findAll().size());
		assertEquals(2, marcaRepository.findAll().size());
		
		
		movilRepository.delete(samsungMovil);
		assertEquals(1, movilRepository.findAll().size());
		assertEquals(1, modeloRepository.findAll().size());
		assertEquals(2, marcaRepository.findAll().size());

		
	}

}
