package com.apimovil.models.dto;

import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.TamanioPantalla;

import lombok.Data;

@Data
public class ResumenDTO {
	private Modelo modelo;
	private TamanioPantalla tamanioPantalla;
	private int almacenamiento;
	private double ram;
	private double peso;
	private int bateria;
	private double precio;
	
	public ResumenDTO(Modelo modelo, TamanioPantalla tamanioPantalla, int almacenamiento, double ram, double peso,
			int bateria, double precio) {
		super();
		this.modelo = modelo;
		this.tamanioPantalla = tamanioPantalla;
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.peso = peso;
		this.bateria = bateria;
		this.precio = precio;
	}
	
}

