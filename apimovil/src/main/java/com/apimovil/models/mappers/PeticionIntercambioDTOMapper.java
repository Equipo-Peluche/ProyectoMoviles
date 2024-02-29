package com.apimovil.models.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import com.apimovil.models.dto.mongo.PeticionIntercambioDTO;
import com.apimovil.models.entities.mongo.PeticionIntercambio;

public class PeticionIntercambioDTOMapper implements MyMapper<PeticionIntercambio, PeticionIntercambioDTO>{

	@Autowired
	AnuncioIntercambioDTOMapper anuncioIntercambioDTOMapper;

	@Override
	public PeticionIntercambioDTO map(PeticionIntercambio t) {
		return new PeticionIntercambioDTO(t.getUsername(),
				t.getAceptada(),
				t.getFecha(),
				anuncioIntercambioDTOMapper.map(t.getAnuncio()),
				anuncioIntercambioDTOMapper.map(t.getAnuncioIntercambioSalida()));
	
	}
}
