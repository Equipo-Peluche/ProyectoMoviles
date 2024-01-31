package com.apimovil.models.dto;

import java.time.LocalDate;

import com.apimovil.utiles.DoubleIntervalo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovilFilterRequestDTO {
	private String marca;
	
	private String modelo;
	
	private String tecnologiaPantalla;

	private Integer ram;
	
	private Double camara;
	
	private LocalDate fechaLanzamiento;

	private DoubleIntervalo intervaloPrecio;

	private DoubleIntervalo intervaloPeso;

	private DoubleIntervalo intervaloTamanio;

	private Integer megapixeles;

	private Integer almacenamiento;
	private Long visitas;

	private String procesador;
	
	private Integer bateria;

	private Boolean nfc;

	public boolean isBetweenPrecio(Double precio) {
		return intervaloPrecio.isBetween(precio);
	}

	public boolean isBetweenPeso(Double peso) {
		return intervaloPeso.isBetween(peso);
	}

	public boolean isBetweenTamanioPantalla(Double tamanio) {
		return intervaloTamanio.isBetween(tamanio);
	}

	public boolean isAnyFieldOfPrecioNull() {
		return intervaloPrecio.isAnyFieldNull();
	}

	public boolean isAnyFieldOfPesoNull() {
		return intervaloPeso.isAnyFieldNull();
	}

	public MovilFilterRequestDTO(String marca, String modelo, String tecnologiaPantalla,
			Integer ram, Integer megapixeles, String procesador) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.tecnologiaPantalla = tecnologiaPantalla;
		this.ram = ram;
		this.megapixeles = megapixeles;
		this.procesador = procesador;
	}


	public boolean isAnyFieldOfTamanioPantalla() {
		return intervaloTamanio.isAnyFieldNull();
	}
	
}
