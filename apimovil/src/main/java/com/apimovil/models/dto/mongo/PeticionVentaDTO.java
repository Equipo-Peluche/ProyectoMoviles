package com.apimovil.models.dto.mongo;

import java.time.LocalDate;

import com.apimovil.models.dto.AnuncioResponseDTO;

import lombok.Data;

@Data
public class PeticionVentaDTO extends PeticionDTO{

	private Double precio;

	public PeticionVentaDTO(String usuario, Boolean aceptada, LocalDate fecha, AnuncioResponseDTO anuncio,
			Double precio) {
		super(usuario, aceptada, fecha, anuncio);
		this.precio = precio;
	}
	
}
