package com.apimovil.models.dto;

import java.time.LocalDate;

import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.Procesador;
import com.apimovil.models.entities.TamanioPantalla;
import com.apimovil.models.entities.TecnologiaPantalla;

import lombok.Data;

@Data
public class MovilDTO {
	private Procesador procesador;
	private Modelo modelo;
	private TamanioPantalla tamanioPantalla;
	private TecnologiaPantalla tecnologiaPantalla;
	private int almacenamiento;
	private double ram;
	private double peso;
	private double camara;
	private int bateria;
	private boolean nfc;
	private double precio;
	private LocalDate fechaLanzamiento;
	private double alto;
	private double ancho;
	private double grosor;
	
	public MovilDTO(Procesador procesador, Modelo modelo, TamanioPantalla tamanioPantalla,
			TecnologiaPantalla tecnologiaPantalla, int almacenamiento, double ram, double peso, double camara,
			int bateria, boolean nfc, double precio, LocalDate fechaLanzamiento, double alto, double ancho,
			double grosor) {
		super();
		this.procesador = procesador;
		this.modelo = modelo;
		this.tamanioPantalla = tamanioPantalla;
		this.tecnologiaPantalla = tecnologiaPantalla;
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.peso = peso;
		this.camara = camara;
		this.bateria = bateria;
		this.nfc = nfc;
		this.precio = precio;
		this.fechaLanzamiento = fechaLanzamiento;
		this.alto = alto;
		this.ancho = ancho;
		this.grosor = grosor;
	}
	
	
}
