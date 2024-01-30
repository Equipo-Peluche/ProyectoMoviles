package com.apimovil.models.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;

public class FilterModelo implements IFilter {

	@Override
	public List<Movil> filter(List<Movil> lista, MovilFilterRequestDTO request) {
		if (request.getModelo() == null) {
			return lista;
		}
		return lista.stream().filter((m) -> m.getModelo().getNombre().equalsIgnoreCase(request.getModelo()))
				.collect(Collectors.toList());
	}

}
