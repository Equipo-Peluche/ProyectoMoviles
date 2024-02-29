package com.apimovil.models.dto;

import lombok.Data;

@Data
public class AnuncioIntercambioDTO extends AnuncioResponseDTO{

	private Integer estadoMinimo;
	
	public AnuncioIntercambioDTO(Integer estadoMinimo, String username, String marca, String modelo, Integer estado) {
		super(username, marca, modelo, estado);
		this.estadoMinimo = estadoMinimo;
	}

}
