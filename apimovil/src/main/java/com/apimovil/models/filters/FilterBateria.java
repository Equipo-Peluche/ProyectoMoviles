package com.apimovil.models.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;

public class FilterBateria implements IFilter {

	@Override
	public List<Movil> filter(List<Movil> lista, MovilFilterRequestDTO request) {
		if (request.getBateria()==null){
			return lista;
		}
		return lista.stream()
				.filter(e-> e.getBateria()>= request.getBateria())
				.collect(Collectors.toList());
	}

}
