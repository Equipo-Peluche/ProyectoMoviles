package com.apimovil.models.dto.mongo;

import java.time.LocalDate;

import com.apimovil.models.dto.AnuncioResponseDTO;

import lombok.Data;

@Data
public class PeticionIntercambioDTO extends PeticionDTO {

	private AnuncioResponseDTO anuncioIntercambioSalida;

	public PeticionIntercambioDTO(String usuario, Boolean aceptada, LocalDate fecha, AnuncioResponseDTO anuncio,
			AnuncioResponseDTO anuncioIntercambioSalida) {
		super(usuario, aceptada, fecha, anuncio);
		this.anuncioIntercambioSalida = anuncioIntercambioSalida;
	}

}
