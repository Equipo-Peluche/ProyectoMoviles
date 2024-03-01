package com.apimovil.models.entities.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Document

public class AnuncioIntercambio extends Anuncio {

	@Min(value = 1, message = "El estado mínimo debe ser mayor que 0")
	@Max(value = 5, message = "El estado máximo debe ser menor que 5")
	private int estadoMinimo;

	public AnuncioIntercambio(Integer referencia,UserEntity user, String marca, String modelo, int estado,
			@Min(value = 1, message = "El estado mínimo debe ser mayor que 0") @Max(value = 5, message = "El estado máximo debe ser menor que 5") int estadoMinimo,Boolean isCerrado) {
		super(referencia,user, marca, modelo, estado,isCerrado);
		this.estadoMinimo = estadoMinimo;
	}

	public String getUsername() {
		return this.getUser().getUsername();
	}
	
}
