package com.apimovil.models.mappers;

import com.apimovil.models.dto.AnuncioVentaDTO;
import com.apimovil.models.entities.mongo.AnuncioVenta;

public class AnuncioVentaDTOMapper implements MyMapper<AnuncioVenta, AnuncioVentaDTO>{

	@Override
	public AnuncioVentaDTO map(AnuncioVenta t) {
		AnuncioVentaDTO anuncioVenta = new AnuncioVentaDTO(
				t.getPrecio(),
				t.getUsername(),
				t.getMarca(),
				t.getModelo(),
				t.getEstado()
				);
		return anuncioVenta;
	}
}
