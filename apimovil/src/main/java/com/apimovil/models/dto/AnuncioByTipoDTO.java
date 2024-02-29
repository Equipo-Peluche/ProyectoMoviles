package com.apimovil.models.dto;

import jakarta.validation.constraints.NotNull;

public class AnuncioByTipoDTO {

	@NotNull(message = "Tienes que especificar el tipo: ['Venta' , 'Intercambio']")
	private String tipo;
	
}
