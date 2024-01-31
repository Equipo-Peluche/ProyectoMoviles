package com.apimovil.models.mappers;

import com.apimovil.models.dto.MovilDTO;
import com.apimovil.models.dto.ResumenDTO;
import com.apimovil.models.entities.Movil;

public class MovilDTOMapper implements MyMapper<Movil, MovilDTO>{

	@Override
	public MovilDTO map(Movil t) {
		MovilDTO movilDTO = new MovilDTO(
				t.getProcesador(),
				t.getModelo(),
				t.getTamanioPantalla(),
				t.getTecnologiaPantalla(),
				t.getAlmacenamiento(),
				t.getRam(),
				t.getPeso(),
				t.getCamara(),
				t.getBateria(),
				t.isNfc(),
				t.getPrecio(),
				t.getFechaLanzamiento(),
				t.getAlto(),
				t.getAncho(),
				t.getGrosor());
		return movilDTO;
	}

}
