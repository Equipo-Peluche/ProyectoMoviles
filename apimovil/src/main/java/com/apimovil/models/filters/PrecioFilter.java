package com.apimovil.models.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;

public class PrecioFilter implements IFilter{

	@Override
	public List<Movil> filter(List<Movil> lista, MovilFilterRequestDTO request) {
		if(request.isAnyFieldOfPrecioNull()) {
			return lista;
		}
		return lista.stream().filter(t -> request.isBetweenPrecio(t.getPrecio())).collect(Collectors.toList());
	}

}
