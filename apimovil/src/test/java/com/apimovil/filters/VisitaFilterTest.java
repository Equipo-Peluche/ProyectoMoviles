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
import com.apimovil.models.filters.FilterVisita;
import com.apimovil.models.om.MarcaOM;
import com.apimovil.models.om.ModeloOM;
import com.apimovil.models.om.ProcesadorOM;
import com.apimovil.models.om.TamanioPantallaOM;
import com.apimovil.models.om.TecnologiaPantallaOM;

@SpringBootTest
class VisitaFilterTest {

	TecnologiaPantallaOM pantallaOM = new TecnologiaPantallaOM();
	MarcaOM marcaOM = new MarcaOM();
	ModeloOM modeloOM;
	ProcesadorOM procesadorOM = new ProcesadorOM();
	TamanioPantallaOM tamanioPantallaOM = new TamanioPantallaOM();

	@Test
	void test() {
		// Le doy valor a las distintas visitas
		Long cien = 100l;
		Long trescientas = 300l;
		Long quinientas = 500l;
		modeloOM = new ModeloOM(marcaOM);

		// Creo los móviles
		Movil movilSamsung = new Movil(pantallaOM.getData().get(0), modeloOM.getData().get(0),
				procesadorOM.getData().get(0), tamanioPantallaOM.getData().get(0), 1, 1, 1, 1, 1, false, 10,
				LocalDate.of(2022, 4, 5), 1, 1, 1, cien);
		Movil movilSamsungDos = new Movil(pantallaOM.getData().get(0), modeloOM.getData().get(1),
				procesadorOM.getData().get(0), tamanioPantallaOM.getData().get(0), 1, 1, 1, 1, 1, false, 10,
				LocalDate.of(2022, 4, 5), 1, 1, 1, trescientas);
		Movil movilIphoneX = new Movil(pantallaOM.getData().get(0), modeloOM.getData().get(2),
				procesadorOM.getData().get(0), tamanioPantallaOM.getData().get(0), 1, 1, 1, 1, 1, false, 10,
				LocalDate.of(2022, 4, 5), 1, 1, 1, quinientas);
		Movil movilIphoneXR = new Movil(pantallaOM.getData().get(0), modeloOM.getData().get(3),
				procesadorOM.getData().get(0), tamanioPantallaOM.getData().get(0), 1, 1, 1, 1, 1, false, 10,
				LocalDate.of(2022, 4, 5), 1, 1, 1, cien);
		Movil movilxiaomiNote = new Movil(pantallaOM.getData().get(0), modeloOM.getData().get(4),
				procesadorOM.getData().get(0), tamanioPantallaOM.getData().get(0), 1, 1, 1, 1, 1, false, 10,
				LocalDate.of(2022, 4, 5), 1, 1, 1, cien);
		Movil movilOppo = new Movil(pantallaOM.getData().get(0), modeloOM.getData().get(5),
				procesadorOM.getData().get(0), tamanioPantallaOM.getData().get(0), 1, 1, 1, 1, 1, false, 10,
				LocalDate.of(2022, 4, 5), 1, 1, 1, quinientas);

		// Añado los moviles a la lista de moviles
		List<Movil> miListadoMoviles = new ArrayList<>();
		miListadoMoviles.add(movilSamsung);
		miListadoMoviles.add(movilSamsungDos);
		miListadoMoviles.add(movilIphoneX);
		miListadoMoviles.add(movilIphoneXR);
		miListadoMoviles.add(movilxiaomiNote);
		miListadoMoviles.add(movilOppo);

		// Filtro
		FilterVisita visitaFilter = new FilterVisita();
		MovilFilterRequestDTO movilRequest = new MovilFilterRequestDTO();
		movilRequest.setVisitas(cien);

		List<Movil> resultadoFiltrado = visitaFilter.filter(miListadoMoviles, movilRequest);
		// Verifico resultado >=100 visitas
		int esperadoMoviles = 6;
		assertEquals(esperadoMoviles, resultadoFiltrado.size());

		// Verifico resultado >=300 visitas

		movilRequest.setVisitas(trescientas);
		resultadoFiltrado = visitaFilter.filter(miListadoMoviles, movilRequest);

		int esperadoMovilesVisitasTrescientas = 3;
		assertEquals(esperadoMovilesVisitasTrescientas, resultadoFiltrado.size());

		// Verifico resultado >=500 visitas

		movilRequest.setVisitas(quinientas);
		resultadoFiltrado = visitaFilter.filter(miListadoMoviles, movilRequest);

		int esperadoMovilesVisitasQuinientas = 2;
		assertEquals(esperadoMovilesVisitasQuinientas, resultadoFiltrado.size());

		// Verifico si le paso un valor nulo
		movilRequest.setVisitas(null);
		resultadoFiltrado = visitaFilter.filter(miListadoMoviles, movilRequest);

		int esperadoVacio = miListadoMoviles.size();

		assertEquals(esperadoVacio, resultadoFiltrado.size());

	}

}
