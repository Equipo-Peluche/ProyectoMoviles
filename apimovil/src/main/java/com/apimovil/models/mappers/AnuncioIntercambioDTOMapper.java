package com.apimovil.models.mappers;import com.apimovil.models.dto.AnuncioIntercambioDTO;
import com.apimovil.models.entities.mongo.AnuncioIntercambio;

public class AnuncioIntercambioDTOMapper implements MyMapper<AnuncioIntercambio, AnuncioIntercambioDTO>{

	@Override
	public AnuncioIntercambioDTO map(AnuncioIntercambio t) {
		AnuncioIntercambioDTO anuncioIntercambioDTO = new AnuncioIntercambioDTO(
				t.getEstadoMinimo(),
				t.getUsername(),
				t.getMarca(),
				t.getModelo(),
				t.getEstado());
		return anuncioIntercambioDTO;
	}

}
