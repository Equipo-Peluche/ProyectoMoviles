package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.filters.FilterMarca;
import com.apimovil.models.filters.IFilter;
import com.apimovil.repositories.MovilRepository;
@SpringBootTest
class MarcaFilterTest {
	
	

	@Test
	void testMarcaFilter() {
	
		
		//Creo la marca para poder crear los modelos
		Marca marcaSamsung= new Marca("Samsumg");
		Marca marcaSamsungDos= new Marca("Samsumg");
		
		Marca marcaIphone= new Marca("Iphone");
		//Creo modelos con las marcas anteriores
		Modelo modeloS21= new Modelo("S21", marcaSamsung);
		Modelo modeloS22= new Modelo("S22", marcaSamsungDos);
		
		Modelo modelo15= new Modelo("15", marcaIphone);
		//Creo móviles
		Movil movilSamsung= new Movil(null, modeloS21, null, null, 0, 0, 0, 0, 0, false, 0, null, 0, 0, 0, 0);
		Movil movilSamsungDos= new Movil(null, modeloS22, null, null, 0, 0, 0, 0, 0, false, 0, null, 0, 0, 0, 0);
		Movil movilIphone= new Movil(null, modelo15, null, null, 0, 0, 0, 0, 0, false, 0, null, 0, 0, 0, 0);
		//Añado los moviles a la lista de moviles
		List<Movil> miListadoMoviles=new ArrayList<>();
		miListadoMoviles.add(movilIphone);
		miListadoMoviles.add(movilSamsung);
		miListadoMoviles.add(movilSamsungDos);
		
		
		// Filtro
		FilterMarca marcaFilter= new FilterMarca();
		
		
		MovilFilterRequestDTO movilRequest= new MovilFilterRequestDTO();
		
		movilRequest.setMarca("Samsumg");
		
		
	
		List<Movil> resultadoFiltrado=marcaFilter.filter(miListadoMoviles,movilRequest);
	    
		// Verificar resultado samsung
		int esperadoSamsung=2;
		assertEquals(esperadoSamsung, resultadoFiltrado.size());
		
		
		
		//Verificar resultado Iphone
		movilRequest.setMarca("Iphone");
		resultadoFiltrado=marcaFilter.filter(miListadoMoviles,movilRequest);
		
		int esperadoIphone=1;
		assertEquals(esperadoIphone, resultadoFiltrado.size());
		
		// Vificar que no hay moviles
		movilRequest.setMarca(null);
		resultadoFiltrado=marcaFilter.filter(miListadoMoviles,movilRequest);
		
		int esperadoVacio=miListadoMoviles.size();
		
		assertEquals(esperadoVacio, resultadoFiltrado.size());
		
	
	}
	

}
