package com.apimovil.models.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;

public class FilterMarca implements IFilter {

	@Override
	public List<Movil> filter(List<Movil> lista, MovilFilterRequestDTO request) {
		if (request.getMarca() == null) {
			return lista;
		}
		return lista.stream().filter((m) -> m.getNombreMarca().equalsIgnoreCase(request.getMarca()))
				.collect(Collectors.toList());
	}

}
