package com.apimovil.models.entities.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document

public class AnuncioIntercambio extends Anuncio {

	@Min(value = 1, message = "El estado mínimo debe ser mayor que 0")
	@Max(value = 5, message = "El estado máximo debe ser menor que 5")
	private int estadoMinimo;

	public AnuncioIntercambio(UserEntity user, String marca, String modelo, int estado,
			@Min(value = 1, message = "El estado mínimo debe ser mayor que 0") @Max(value = 5, message = "El estado máximo debe ser menor que 5") int estadoMinimo) {
		super(user, marca, modelo, estado);
		this.estadoMinimo = estadoMinimo;
	}

	public String getUsername() {
		return this.getUser().getUsername();
	}
	
}
