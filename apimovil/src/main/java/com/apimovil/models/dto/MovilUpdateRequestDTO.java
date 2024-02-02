package com.apimovil.models.dto;

import com.apimovil.models.entities.Modelo;

import lombok.Data;

@Data
public class MovilUpdateRequestDTO {
	private String marca;
	private String modelo;
	private Double precio;
	
	public MovilUpdateRequestDTO(String marca,String modelo, Double precio) {
		super();
		this.marca=marca;
		this.modelo = modelo;
		this.precio = precio;
	}
	
}
