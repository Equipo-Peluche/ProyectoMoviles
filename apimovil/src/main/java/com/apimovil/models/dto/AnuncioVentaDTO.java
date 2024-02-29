package com.apimovil.models.dto;

import lombok.Data;

@Data
public class AnuncioVentaDTO extends AnuncioResponseDTO {
	
	private Double precio;
	
	public AnuncioVentaDTO(Double precio, String username, String marca, String modelo, Integer estado) {
		super(username, marca, modelo, estado);
		this.precio = precio;
	}

}
