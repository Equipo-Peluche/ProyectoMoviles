package com.apimovil.models.entities;

import java.time.LocalDate;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
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
	@NotNull
	private Procesador procesador;
	// private Pantalla pantalla;
	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(unique = true)
	@NotNull(message = "El modelo no puede ser nulo")
	private Modelo modelo;
	
	@ManyToOne
	@NotNull(message = "El tamaño de pantalla no puede ser nulo")
	private TamanioPantalla tamanioPantalla;
	
	@ManyToOne
	@NotNull(message = "La tecnología de pantalla no puede ser nula")
	private TecnologiaPantalla tecnologiaPantalla;
	
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
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaLanzamiento;
	
	private long visitas;
	
	@NotNull(message = "La altura no puede ser nula")
	@Positive(message = "La altura debe ser mayor que cero")
	private Double alto;

	@NotNull(message = "El ancho no puede ser nulo")
	@Positive(message = "El ancho debe ser mayor que cero")
	private Double ancho;

	@NotNull(message = "El grosor no puede ser nulo")
	@Positive(message = "El grosor debe ser mayor que cero")
	private Double grosor;

	public Movil(TecnologiaPantalla tecnologiaPantalla, Modelo modelo, Procesador procesador, TamanioPantalla tamanio,
			int almacenamiento, double ram, double peso, double camara, int bateria, boolean nfc, double precio,
			LocalDate fechaLanzamiento, double ancho, double alto, double grosor, long visitas) {
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

	public String getNombreMarca() {
		return this.modelo.getNombreMarca();
	}
	public Marca getMarca() {
		return this.modelo.getMarca();
	}

	public double getPulgadasPantalla() {
		return this.tamanioPantalla.getPulgadas();
	}

	public String getNombreTecnologiaPantalla() {
		return this.tecnologiaPantalla.getNombre();
	}

	public String getNombreModelo() {
		return this.modelo.getNombre();
	}

	public String getNombreProcesador() {
		return this.procesador.getNombre();
	}
	
	public void aumentarVisita() {
		visitas++;
	}

}
