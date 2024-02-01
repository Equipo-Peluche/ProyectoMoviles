package com.apimovil.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class MovilRequestRemoveDTO {
	private String marca;
	private String modelo;
	
	public MovilRequestRemoveDTO(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	
	

}
