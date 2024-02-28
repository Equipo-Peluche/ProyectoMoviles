package com.apimovil.models.entities.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public abstract class Anuncio {

	@Id
	@Field("_id")
	private ObjectId idAnuncio;
	@Field ("usuario")
	
	@NotNull(message = "El usuario no puede ser nulo")
	private User user;
	
	@NotNull(message = "El marca no puede ser nulo")
	private String marca;
	
	@NotNull(message = "El modelo no puede ser nulo")
	private String modelo;

	
	public Anuncio(User user,String marca,String modelo) {
		super();
		this.user = user;
		this.marca = marca;
		this.modelo = modelo;
	}
	
	
}
