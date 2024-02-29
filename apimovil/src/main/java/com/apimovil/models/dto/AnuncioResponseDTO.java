package com.apimovil.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class AnuncioResponseDTO {

	private String username;
	private String marca;
	private String modelo;
	private Integer estado;
	
}
