package com.apimovil.models.dto;

import jakarta.validation.constraints.*;

import com.apimovil.models.entities.Modelo;

import lombok.Data;

@Data
public class MovilUpdateRequestDTO {
	@NotNull(message = "La marca no puede ser nulo")
	private String marca;
	@NotNull(message = "El modelo no puede ser nulo")
	private String modelo;
	@DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que cero")
	private Double precio;
	
	public MovilUpdateRequestDTO(String marca,String modelo, Double precio) {
		super();
		this.marca=marca;
		this.modelo = modelo;
		this.precio = precio;
	}
	
}
