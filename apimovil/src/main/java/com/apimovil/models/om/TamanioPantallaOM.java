package com.apimovil.models.om;

import java.util.ArrayList;
import java.util.List;

import com.apimovil.models.entities.TamanioPantalla;
import com.apimovil.models.entities.TecnologiaPantalla;

public class TamanioPantallaOM implements IOM<TamanioPantalla>{

	@Override
	public List<TamanioPantalla> getData() {
		List<TamanioPantalla> lista = new ArrayList<>();
		
		lista.add(new TamanioPantalla(6.33));
		lista.add(new TamanioPantalla(5.0));
		lista.add(new TamanioPantalla(4.5));
		lista.add(new TamanioPantalla(4.0));
		
		return lista;
	}

}
