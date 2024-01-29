package com.apimovil.models.filters;

import java.util.List;

import com.apimovil.models.dto.MovilRequestDTO;
import com.apimovil.models.entities.Movil;

public interface IFilter {
	
	public List<Movil> filter(List<Movil> lista,MovilRequestDTO request);
	
}
