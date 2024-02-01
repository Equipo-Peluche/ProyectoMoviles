package com.apimovil.models.mappers;

import com.apimovil.models.dto.UpdateRequestDTO;
import com.apimovil.models.entities.Movil;

public class UpdateRequestDTOMapper implements MyMapper<Movil, UpdateRequestDTO> {

	@Override
	public UpdateRequestDTO map(Movil t) {
		return new UpdateRequestDTO(
				t.getModelo(),
				t.getPrecio()
				);
	}

}
