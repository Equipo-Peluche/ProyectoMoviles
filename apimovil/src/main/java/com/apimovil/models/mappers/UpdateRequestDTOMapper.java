package com.apimovil.models.mappers;

import com.apimovil.models.dto.MovilUpdateRequestDTO;
import com.apimovil.models.entities.Movil;

public class UpdateRequestDTOMapper implements MyMapper<Movil, MovilUpdateRequestDTO> {

	@Override
	public MovilUpdateRequestDTO map(Movil t) {
		return new MovilUpdateRequestDTO(
				t.getNombreModelo(),
				t.getNombreMarca(),
				t.getPrecio()
				);
	}

}
