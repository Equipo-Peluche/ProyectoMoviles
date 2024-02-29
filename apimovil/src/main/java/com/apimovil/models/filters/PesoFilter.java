package com.apimovil.models.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;

public class PesoFilter implements IFilter{

	@Override
	public List<Movil> filter(List<Movil> lista, MovilFilterRequestDTO request) {
		if(request.getIntervaloPeso() == null||request.isAnyFieldOfPesoNull()) {
			return lista;
		}
		return lista.stream()
				.filter(t -> request.isBetweenPeso(t.getPeso()))
				.collect(Collectors.toList());
	}

}
