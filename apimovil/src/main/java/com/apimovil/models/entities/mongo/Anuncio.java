package com.apimovil.models.entities.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Anuncio {

	@Id
	@Field("_id")
	private ObjectId idAnuncio;
	@Field ("usuario")
	
	private User user;
	
	private String marca;
	private String modelo;
	private int estado;
	
}
