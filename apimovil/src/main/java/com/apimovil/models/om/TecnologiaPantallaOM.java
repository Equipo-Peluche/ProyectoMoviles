package com.apimovil.models.om;

import java.util.ArrayList;
import java.util.List;

import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.TecnologiaPantalla;

public class TecnologiaPantallaOM implements IOM<TecnologiaPantalla>{

	@Override
	public List<TecnologiaPantalla> getData() {
		List<TecnologiaPantalla> lista = new ArrayList<>();
		
		lista.add(new TecnologiaPantalla("OLED"));
		lista.add(new TecnologiaPantalla("AMOLED"));
		lista.add(new TecnologiaPantalla("LCD"));
		
		return lista;
	}

}
