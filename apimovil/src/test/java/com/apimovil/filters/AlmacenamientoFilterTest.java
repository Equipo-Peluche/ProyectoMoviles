package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.filters.FilterAlmacenamiento;
import com.apimovil.models.filters.FilterMarca;
@SpringBootTest
class AlmacenamientoFilterTest {

	@Test
	void test() {
		//Le doy valor a las distintas capacidades
		int capacidadBaja=64;
		int capacidadMedia=128;
		int capacidadAlta=256;
		int sinCapacidad=0;
		
		//Creo los móviles
		
		Movil movilSamsung= new Movil(null, null, null, null, capacidadMedia, 0, 0, 0, 0, false, 0, null, 0, 0, 0, 0);
		Movil movilSamsungDos= new Movil(null, null, null, null, capacidadMedia, 0, 0, 0, 0, false, 0, null, 0, 0, 0, 0);
		Movil movilIphoneX= new Movil(null, null, null, null, capacidadAlta, 0, 0, 0, 0, false, 0, null, 0, 0, 0, 0);
		Movil movilIphoneXR= new Movil(null, null, null, null, capacidadAlta, 0, 0, 0, 0, false, 0, null, 0, 0, 0, 0);
		Movil movilxiaomiNote= new Movil(null, null, null, null, capacidadBaja, 0, 0, 0, 0, false, 0, null, 0, 0, 0, 0);
		Movil movilOppo= new Movil(null, null, null, null, capacidadBaja, 0, 0, 0, 0, false, 0, null, 0, 0, 0, 0);
		
		//Añado los moviles a la lista de moviles
		List<Movil> miListadoMoviles=new ArrayList<>();
		miListadoMoviles.add(movilSamsung);
		miListadoMoviles.add(movilSamsungDos);
		miListadoMoviles.add(movilIphoneX);
		miListadoMoviles.add(movilIphoneXR);
		miListadoMoviles.add(movilxiaomiNote);
		miListadoMoviles.add(movilOppo);
		
		//Filtro
		FilterAlmacenamiento almacenamientoFilter= new FilterAlmacenamiento();
		
		MovilFilterRequestDTO movilRequestDTO = new MovilFilterRequestDTO();
		
		movilRequestDTO.setAlmacenamiento(sinCapacidad);
		
		List<Movil> resultadoFiltrado= almacenamientoFilter.filter(miListadoMoviles, movilRequestDTO);
		
		//Verifico resultados capacidad a 0
		int esperadoMoviles=6;
		assertEquals(esperadoMoviles, resultadoFiltrado.size());
		
		//Verfico resultados capacidad baja
		movilRequestDTO.setAlmacenamiento(capacidadBaja);
		resultadoFiltrado= almacenamientoFilter.filter(miListadoMoviles, movilRequestDTO);
		
		int esperadoMovilesCapacidadBaja=6;
		assertEquals(esperadoMovilesCapacidadBaja, resultadoFiltrado.size());
		
		//Verifico resiltados capacidad media
		
		movilRequestDTO.setAlmacenamiento(capacidadMedia);
		resultadoFiltrado= almacenamientoFilter.filter(miListadoMoviles, movilRequestDTO);
		
		int esperadoMovilesCapacidadMedia=4;
		assertEquals(esperadoMovilesCapacidadMedia, resultadoFiltrado.size());
	
	
		//Verifico resiltados capacidad alta
		movilRequestDTO.setAlmacenamiento(capacidadAlta);
		resultadoFiltrado= almacenamientoFilter.filter(miListadoMoviles, movilRequestDTO);
		
		int esperadoMovilesCapacidadAlta=2;
		assertEquals(esperadoMovilesCapacidadAlta, resultadoFiltrado.size());
		
		//Verifico si le paso un valor nulo
		movilRequestDTO.setAlmacenamiento(null);
		resultadoFiltrado=almacenamientoFilter.filter(miListadoMoviles,movilRequestDTO);
		
		int esperadoVacio=miListadoMoviles.size();
		
		assertEquals(esperadoVacio, resultadoFiltrado.size());
		
	
		
		
	
	
	
	}

}
