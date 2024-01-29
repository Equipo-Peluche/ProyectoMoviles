package com.apimovil.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovilRequestDTO {
	private String nombre;
	private int ram;
	private double precioMin;
	private double precioMax;
	
}
