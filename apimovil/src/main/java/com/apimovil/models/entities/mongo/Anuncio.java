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
	
	private Integer referencia;
	
	@Field ("usuario")
	
	@NotNull(message = "El usuario no puede ser nulo")
	private UserEntity user;
	
	@NotNull(message = "El marca no puede ser nulo")
	private String marca;
	
	@NotNull(message = "El modelo no puede ser nulo")
	private String modelo;

	@NotNull(message = "El estado no puede ser nulo")
	private int estado;

	private Boolean isCerrado;
	public Anuncio(Integer referencia,UserEntity user, String marca, String modelo, int estado,Boolean isCerrado) {
		this.user = user;
		this.marca = marca;
		this.modelo = modelo;
		this.estado = estado;
		this.isCerrado=isCerrado;
	}
	
}
