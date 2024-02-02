package com.apimovil.models.dto;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.TamanioPantalla;

import lombok.Data;

@Data
public class ResumenDTO {
	@NotNull(message = "El modelo no puede ser nulo")
	private String marca;
	@NotNull(message = "El modelo no puede ser nulo")
	private String modelo;
	@NotNull(message = "El tamaño de pantalla no puede ser nulo")
	private Double tamanioPantalla;
	@Min(value = 1, message = "El almacenamiento debe ser mayor que 0")
	private int almacenamiento;
	@Min(value = 1, message = "La RAM debe ser mayor que 0")
	private double ram;
	@Positive(message = "El valor debe de ser positivo")
	private double peso;
	@Positive(message = "El valor debe de ser positivo")
	private int bateria;
	@DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que cero")
	private double precio;
	
	public ResumenDTO(String marca, String modelo, Double tamanioPantalla, int almacenamiento, double ram, double peso,
			int bateria, double precio) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.tamanioPantalla = tamanioPantalla;
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.peso = peso;
		this.bateria = bateria;
		this.precio = precio;
	}
	
}

