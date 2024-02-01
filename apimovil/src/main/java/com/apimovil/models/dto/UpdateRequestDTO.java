package com.apimovil.models.dto;

import com.apimovil.models.entities.Modelo;

import lombok.Data;

@Data
public class UpdateRequestDTO {

	private Modelo modelo;
	private Double precio;
	
	public UpdateRequestDTO(Modelo modelo, Double precio) {
		super();
		this.modelo = modelo;
		this.precio = precio;
	}
}
