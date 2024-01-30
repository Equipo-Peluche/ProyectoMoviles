package com.apimovil.models.dto;

import com.apimovil.utiles.DoubleIntervalo;
import com.apimovil.utiles.IntegerIntervalo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovilFilterRequestDTO {
	private String marca;
	private String modelo;
	private Integer tamanioPantalla;
	private String tecnologiaPantalla;

	private Integer ram;

	private DoubleIntervalo intervaloPrecio;

	private DoubleIntervalo intervaloPeso;

	private Integer megapixeles;

	private Integer almacenamiento;
	private Long visitas;

	private String procesador;

	private Boolean nfc;

	public boolean isBetweenPrecio(Double precio) {
		return intervaloPrecio.isBetween(precio);
	}

	public boolean isBetweenPeso(Double precio) {
		return intervaloPeso.isBetween(precio);
	}

	public boolean isAnyFieldOfPrecioNull() {
		return intervaloPrecio.isAnyFieldNull();
	}

	public boolean isAnyFieldOfPesoNull() {
		return intervaloPeso.isAnyFieldNull();
	}

	public MovilFilterRequestDTO(String marca, String modelo, Integer tamanioPantalla, String tecnologiaPantalla,
			Integer ram, Integer megapixeles, String procesador) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.tamanioPantalla = tamanioPantalla;
		this.tecnologiaPantalla = tecnologiaPantalla;
		this.ram = ram;
		this.megapixeles = megapixeles;
		this.procesador = procesador;
	}

}
