package com.apimovil.models.om;

import java.util.ArrayList;
import java.util.List;

import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.Procesador;

public class MarcaOM implements IOM<Marca>{

	@Override
	public List<Marca> getData() {
		List<Marca> lista = new ArrayList<>();
		
		lista.add(new Marca("iPhone"));
		lista.add(new Marca("Samsung"));
		lista.add(new Marca("Xiaomi"));
		lista.add(new Marca("Huawei"));
		lista.add(new Marca("OPPO"));
		lista.add(new Marca("Honor"));
		lista.add(new Marca("Motorola"));
		
		return lista;
	}

}
