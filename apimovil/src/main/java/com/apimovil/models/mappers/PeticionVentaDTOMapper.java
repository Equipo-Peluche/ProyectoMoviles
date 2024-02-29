package com.apimovil.models.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import com.apimovil.models.dto.mongo.PeticionDTO;
import com.apimovil.models.dto.mongo.PeticionVentaDTO;
import com.apimovil.models.entities.mongo.PeticionVenta;

public class PeticionVentaDTOMapper implements MyMapper<PeticionVenta, PeticionVentaDTO>{

	@Autowired
	AnuncioVentaDTOMapper anuncioVentaDTOMapper;
	
	@Override
	public PeticionVentaDTO map(PeticionVenta t) {
		return new PeticionVentaDTO(t.getUsername(),
				t.getAceptada(),
				t.getFecha(),
				anuncioVentaDTOMapper.map(t.getAnuncio()),
				t.getPrecio());
	}

}
