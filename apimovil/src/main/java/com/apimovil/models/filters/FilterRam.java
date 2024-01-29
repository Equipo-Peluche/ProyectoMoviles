package com.apimovil.models.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;

public class FilterRam implements IFilter{

	@Override
	public List<Movil> filter(List<Movil> lista,MovilFilterRequestDTO request) {
		if(request.getRam()==null) {
			return lista;
		}
		return lista.stream().filter((e) -> e.getRam()>= request.getRam()).collect(Collectors.toList());
	}

}
