package com.apimovil.filters;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.filters.FilterVisita;
@SpringBootTest
class VisitaFilterTest {

	@Test
	void test() {
		//Le doy valor a las distintas visitas
				Long cien=100l;
				Long trescientas=300l;
				Long quinientas=500l;
				
				
				//Creo los móviles
				
				Movil movilSamsung= new Movil(null, null, null, null, 0, 0, 0, 0, 0, false, 0, null, 0, 0, 0, cien);
				Movil movilSamsungDos= new Movil(null, null, null, null, 0, 0, 0, 0, 0, false, 0, null, 0, 0, 0, trescientas);
				Movil movilIphoneX= new Movil(null, null, null, null, 0, 0, 0, 0, 0, false, 0, null, 0, 0, 0,quinientas);
				Movil movilIphoneXR= new Movil(null, null, null, null, 0, 0, 0, 0, 0, false, 0, null, 0, 0, 0, cien);
				Movil movilxiaomiNote= new Movil(null, null, null, null, 0, 0, 0, 0, 0, false, 0, null, 0, 0, 0, cien);
				Movil movilOppo= new Movil(null, null, null, null, 0, 0, 0, 0, 0, false, 0, null, 0, 0, 0, quinientas);
				
				
				//Añado los moviles a la lista de moviles
				List<Movil> miListadoMoviles=new ArrayList<>();
				miListadoMoviles.add(movilSamsung);
				miListadoMoviles.add(movilSamsungDos);
				miListadoMoviles.add(movilIphoneX);
				miListadoMoviles.add(movilIphoneXR);
				miListadoMoviles.add(movilxiaomiNote);
				miListadoMoviles.add(movilOppo);
				
				//Filtro 
				FilterVisita visitaFilter= new FilterVisita();
				MovilFilterRequestDTO movilRequest= new MovilFilterRequestDTO();
				movilRequest.setVisitas(cien);
				
				List<Movil>resultadoFiltrado=visitaFilter.filter(miListadoMoviles, movilRequest);
				//Verifico resultado >=100 visitas
				int esperadoMoviles=6;
				assertEquals(esperadoMoviles, resultadoFiltrado.size());
	
				//Verifico resultado >=300 visitas
				
				movilRequest.setVisitas(trescientas);
				resultadoFiltrado= visitaFilter.filter(miListadoMoviles, movilRequest);
				
				int esperadoMovilesVisitasTrescientas=3;
				assertEquals(esperadoMovilesVisitasTrescientas, resultadoFiltrado.size());
				

				//Verifico resultado >=500 visitas
				
				movilRequest.setVisitas(quinientas);
				resultadoFiltrado= visitaFilter.filter(miListadoMoviles, movilRequest);
				
				int esperadoMovilesVisitasQuinientas=2;
				assertEquals(esperadoMovilesVisitasQuinientas, resultadoFiltrado.size());
					
				
				//Verifico si le paso un valor nulo
				movilRequest.setVisitas(null);
				resultadoFiltrado=visitaFilter.filter(miListadoMoviles,movilRequest);
				
				int esperadoVacio=miListadoMoviles.size();
				
				assertEquals(esperadoVacio, resultadoFiltrado.size());
	
	
	
	
	
	
	
	
	
	}

}
