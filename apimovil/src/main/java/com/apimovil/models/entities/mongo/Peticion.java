package com.apimovil.models.entities.mongo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public abstract class Peticion<T extends Anuncio> {

	@Id
	@Field("_id")
	private ObjectId idPeticion;
	@Field("referencia")
	private Integer referencia;
	@Field("usuario")
	private UserEntity usuario;
	private Boolean aceptada;
	private LocalDate fecha;
	private T anuncio;

	public Peticion(Integer referencia,UserEntity usuario, Boolean aceptada, LocalDate fecha, T anuncio) {
		super();
		this.usuario = usuario;
		this.aceptada = aceptada;
		this.fecha = fecha;
		this.anuncio = anuncio;
	}
	
	public String getUsername() {
		return this.usuario.getUsername();
	}

}
