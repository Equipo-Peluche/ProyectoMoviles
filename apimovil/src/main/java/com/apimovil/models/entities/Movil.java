package com.apimovil.models.entities;

import java.time.LocalDate;

import org.hibernate.type.SqlTypes;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.apimovil.models.Dimension;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Movil {

	public Movil(int almacenamiento, double ram, double peso, double camara, int bateria, boolean nfc, double precio,
			LocalDate fechaLanzamiento, Dimension dimensiones) {
		super();
		this.almacenamiento = almacenamiento;
		this.ram = ram;
		this.peso = peso;
		this.camara = camara;
		this.bateria = bateria;
		this.nfc = nfc;
		this.precio = precio;
		this.fechaLanzamiento = fechaLanzamiento;
		this.dimensiones = dimensiones;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	//private Procesador procesador;
	//private Pantalla pantalla;
	//private Modelo modelo;
	//private TamanoPantalla tamanoPantalla;
	//private TecnologiaPantalla tecnologiaPantalla;
	private int almacenamiento;
	private double ram;
	private double peso;
	private double camara;
	private int bateria;
	private boolean nfc;
	private double precio;
	private LocalDate fechaLanzamiento;
	@OneToOne
	private Dimension dimensiones;
	
}
