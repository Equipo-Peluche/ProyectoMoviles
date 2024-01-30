package com.apimovil.models.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;

public class ProcesadorFilter implements IFilter {

	@Override
	public List<Movil> filter(List<Movil> lista, MovilFilterRequestDTO request) {
		if(request.getProcesador()==null) {
			return lista;
		}
		String targetProcesador = request.getProcesador();
		return lista.stream()
		        .filter(movil -> targetProcesador.equals(movil.getNombreProcesador()))
		        .collect(Collectors.toList());

	}

}
