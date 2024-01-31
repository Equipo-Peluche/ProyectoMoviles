package com.apimovil.models.om;

import java.util.ArrayList;
import java.util.List;

import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.Modelo;

public class ModeloOM implements IOM<Modelo>{

	private MarcaOM marcaOM;
	
	public ModeloOM(MarcaOM marcaOM) {
		super();
		this.marcaOM = marcaOM;
	}

	@Override
	public List<Modelo> getData() {
		List<Modelo> lista = new ArrayList<>();
		
		List<Marca> listaMarcas = marcaOM.getData();
		
		lista.add(new Modelo("13", listaMarcas.get(0)));
		lista.add(new Modelo("15 Pro max", listaMarcas.get(0)));
		lista.add(new Modelo("S9", listaMarcas.get(1)));
		lista.add(new Modelo("S21", listaMarcas.get(1)));
		lista.add(new Modelo("Redmi Note 10", listaMarcas.get(2)));
		lista.add(new Modelo("P40 Pro", listaMarcas.get(3)));
		lista.add(new Modelo("Find X5", listaMarcas.get(4)));
		lista.add(new Modelo("10", listaMarcas.get(5)));
		lista.add(new Modelo("Moto G Power", listaMarcas.get(6)));
		
		return lista;
	}

}
