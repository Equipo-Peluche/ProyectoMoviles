package com.apimovil.models.mappers;

import com.apimovil.models.dto.ResumenDTO;
import com.apimovil.models.entities.Movil;

public class ResumenDTOMapper implements MyMapper<Movil, ResumenDTO> {

	@Override
	public ResumenDTO map(Movil t) {
		return new ResumenDTO(
				t.getModelo(),
				t.getTamanioPantalla(),
				t.getAlmacenamiento(),
				t.getRam(),
				t.getPeso(),
				t.getBateria(),
				t.getPrecio());
	}

}
