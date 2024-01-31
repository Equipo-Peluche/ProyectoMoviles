package com.apimovil.models.om;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.Procesador;
import com.apimovil.models.entities.TamanioPantalla;
import com.apimovil.models.entities.TecnologiaPantalla;

public class MovilOM implements IOM<Movil>{

	private ModeloOM modeloOM;
	private ProcesadorOM procesadorOM;
	private TamanioPantallaOM tamanioPantallaOM;
	private TecnologiaPantallaOM tecnologiaPantallaOM;
	
	private List<Modelo> listaModelos;
	private List<Procesador> listaProcesador;
	private List<TamanioPantalla> listaTamanios;
	private List<TecnologiaPantalla> listaTecnologia;
	
	public MovilOM(ModeloOM modeloOM, ProcesadorOM procesadorOM, TamanioPantallaOM tamanioPantallaOM,
			TecnologiaPantallaOM tecnologiaPantallaOM) {
		super();
		this.modeloOM = modeloOM;
		this.procesadorOM = procesadorOM;
		this.tamanioPantallaOM = tamanioPantallaOM;
		this.tecnologiaPantallaOM = tecnologiaPantallaOM;
	}

	@Override
	public List<Movil> getData() {
		List<Movil> lista = new ArrayList<>();
		
		this.listaModelos = modeloOM.getData();
		this.listaProcesador = procesadorOM.getData();
		this.listaTamanios = tamanioPantallaOM.getData();
		this.listaTecnologia = tecnologiaPantallaOM.getData();
		
		lista.add(new Movil(listaTecnologia.get(0), listaModelos.get(1) , listaProcesador.get(4), listaTamanios.get(0) , 512, 12, 234.5, 32, 5500, true, 1149.99, LocalDate.of(2023, 9, 10), 111.4, 178.4, 13.6, 0));
		lista.add(new Movil(listaTecnologia.get(1), listaModelos.get(0) , listaProcesador.get(3), listaTamanios.get(1) , 256, 8, 245.4, 32, 4996, true, 999.99, LocalDate.of(2021, 2, 1), 155.4, 178.1, 12.3, 0));
		lista.add(new Movil(listaTecnologia.get(2), listaModelos.get(6) , listaProcesador.get(1), listaTamanios.get(1) , 128, 12, 268.1, 32, 5500, true, 744.3, LocalDate.of(2016, 3, 22), 144.2, 155.4, 11.12, 0));
		lista.add(new Movil(listaTecnologia.get(2), listaModelos.get(3) , listaProcesador.get(1), listaTamanios.get(2) , 512, 8, 213.6, 32, 5500, false, 313.0, LocalDate.of(2019, 6, 15), 125.5, 172.4, 8.22, 0));
		lista.add(new Movil(listaTecnologia.get(0), listaModelos.get(5) , listaProcesador.get(2), listaTamanios.get(0) , 256, 4, 221.9, 32, 5500, true, 123.99, LocalDate.of(2021, 9, 16), 111.8, 196.3, 16.5, 0));
		lista.add(new Movil(listaTecnologia.get(1), listaModelos.get(8) , listaProcesador.get(1), listaTamanios.get(2) , 16, 2, 198.5, 32, 5500, false, 98.3, LocalDate.of(2013, 2, 25), 118.9, 163.4, 22.6, 0));
		
		return lista;
	}

}
