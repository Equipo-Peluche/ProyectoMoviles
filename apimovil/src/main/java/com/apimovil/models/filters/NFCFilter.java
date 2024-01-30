package com.apimovil.models.filters;

import java.util.List;
import java.util.stream.Collectors;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;

public class NFCFilter implements IFilter {

	@Override
	public List<Movil> filter(List<Movil> lista, MovilFilterRequestDTO request) {
	       if (request.isNfc() == false) {
	            return lista;
	        }

	        boolean targetNfc = request.isNfc();
	        return lista.stream()
	                .filter(t -> (t.isNfc() == targetNfc))
	                .collect(Collectors.toList());
	    }
	}