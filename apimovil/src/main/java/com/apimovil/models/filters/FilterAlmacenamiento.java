package com.apimovil.models.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;

public class FilterAlmacenamiento implements IFilter {

	@Override
	public List<Movil> filter(List<Movil> lista, MovilFilterRequestDTO request) {
		if(request.getAlmacenamiento()==null) {
			return lista;
			
		}
		return lista.stream().filter((a)->a.getAlmacenamiento()>=request.getAlmacenamiento()).collect(Collectors.toList());
	}

}
