package com.apimovil.models.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;

public class FilterScreenSize implements IFilter {

	@Override
	public List<Movil> filter(List<Movil> lista, MovilFilterRequestDTO request) {
		if (request.getIntervaloTamanio() == null || request.isAnyFieldOfTamanioPantalla()) {
			return lista;
		}
		return lista.stream()
				.filter(movil -> request.isBetweenTamanioPantalla(movil.getTamanioPantalla()))
				.collect(Collectors.toList());
	}

}
