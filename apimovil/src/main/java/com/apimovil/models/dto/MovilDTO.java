package com.apimovil.models.dto;

import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.Procesador;
import com.apimovil.models.entities.TamanioPantalla;
import com.apimovil.models.entities.TecnologiaPantalla;

import lombok.Data;

@Data
public class MovilDTO {
	@NotNull(message = "El procesador no puede ser nulo")
	private String procesador;
	@NotNull(message = "El modelo no puede ser nulo")
	private String marca;
	@NotNull(message = "El modelo no puede ser nulo")
	private String modelo;
	@NotNull(message = "El tamaño de pantalla no puede ser nulo")
	private Double tamanioPantalla;
	@NotNull(message = "La tecnología de pantalla no puede ser nula")
	private String tecnologiaPantalla;
	@Min(value = 1, message = "El almacenamiento debe ser mayor que 0")
	private int almacenamiento;
	@Min(value = 1, message = "La RAM debe ser mayor que 0")
	private double ram;
	@Positive(message = "El valor debe de ser positivo")
	private double peso;
	@Min(message = "El valor debe de ser positivo", value = 1)
	private double camara;
	@Positive(message = "El valor debe de ser positivo")
	private int bateria;
	private boolean nfc;
	@DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que cero")
	private double precio;
	@NotNull(message = "La fecha de lanzamiento no puede ser nula")
	private LocalDate fechaLanzamiento;
	@NotNull(message = "La altura no puede ser nula")
	@Positive(message = "La altura debe ser mayor que cero")
	private Double alto;
	@NotNull(message = "El ancho no puede ser nulo")
	@Positive(message = "El ancho debe ser mayor que cero")
	private Double ancho;
	@NotNull(message = "El grosor no puede ser nulo")
	@Positive(message = "El grosor debe ser mayor que cero")
	private Double grosor;
	
	public MovilDTO(String procesador,String marca, String modelo, Double tamanioPantalla,
			String tecnologiaPantalla, int almacenamiento, double ram, double peso, double camara,
			int bateria, boolean nfc, double precio, LocalDate fechaLanzamiento, double alto, double ancho,
			double grosor) {
		super();
		this.procesador = procesador;
		this.marca = marca;
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
