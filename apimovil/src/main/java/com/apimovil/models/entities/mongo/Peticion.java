package com.apimovil.models.entities.mongo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Peticion {
	@Id
	@Field("_id")
	private ObjectId idPeticion;
	@Field("usuario")
	private UserEntity usuario;
	private Boolean aceptada;
	private LocalDate fecha;

	public Peticion(User usuario, Boolean aceptada, LocalDate fecha) {
		super();
		this.usuario = usuario;
		this.aceptada = aceptada;
		this.fecha = fecha;
	}

}
