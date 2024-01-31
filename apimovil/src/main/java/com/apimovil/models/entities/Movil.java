package com.apimovil.models.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Movil {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@ManyToOne
	private Procesador procesador;
	//private Pantalla pantalla;
	@OneToOne
	private Modelo modelo;
	@OneToOne
	private TamanioPantalla tamanioPantalla;
	@ManyToOne
	private TecnologiaPantalla tecnologiaPantalla;
	private int almacenamiento;
	private double ram;
	private double peso;
	private double camara;
	private int bateria;
	private boolean nfc;
	private double precio;
	private LocalDate fechaLanzamiento;
	private long visitas;
	private double alto;
	private double ancho;
	private double grosor;
	
	public Movil(TecnologiaPantalla tecnologiaPantalla, Modelo modelo,
			Procesador procesador,  TamanioPantalla tamanio,
			int almacenamiento, double ram, double peso, double camara,
			int bateria, boolean nfc, double precio, LocalDate fechaLanzamiento,
			double ancho, double alto, double grosor , long visitas) {
		super();
		this.tecnologiaPantalla = tecnologiaPantalla;
		this.modelo = modelo;
		this.procesador = procesador;
		this.tamanioPantalla = tamanio;
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.peso = peso;
		this.camara = camara;
		this.bateria = bateria;
		this.nfc = nfc;
		this.precio = precio;
		this.fechaLanzamiento = fechaLanzamiento;
		this.visitas = visitas;
		this.alto = alto;
		this.ancho = ancho;
		this.grosor = grosor;
	}
	
	public String getMarca() {
		return this.modelo.getMarca();
	}

	public String getNombreProcesador() {
		return procesador.getNombre();
	}
	
	public double getTamanioPantalla() {
		return this.tamanioPantalla.getPulgadas();
	}
	
	public String getNombreModelo() {
		return this.modelo.getNombre();
	}
	
	public String getProcesador() {
		return this.procesador.getNombre();
	}
	
}
