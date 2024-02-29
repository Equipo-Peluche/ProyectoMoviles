package com.apimovil.models.om;

import java.util.ArrayList;
import java.util.List;

import com.apimovil.models.entities.Procesador;

public class ProcesadorOM implements IOM<Procesador>{

	@Override
	public List<Procesador> getData() {
		List<Procesador> lista = new ArrayList<>();
		
		lista.add(new Procesador(3.55,"Snapdragon 3600"));
		lista.add(new Procesador(3.12,"Snapdragon 4400"));
		lista.add(new Procesador(5.33,"M2"));
		lista.add(new Procesador(4.87,"M4"));
		
		return lista;
	}

	
	
	
}
