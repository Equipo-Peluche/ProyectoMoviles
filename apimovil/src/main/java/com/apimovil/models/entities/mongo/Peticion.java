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
@AllArgsConstructor
public abstract class Peticion {
	@Id
	@Field("_id")
	private ObjectId idPeticion;
	@Field("usuario")
	private User usuario;
	private Boolean aceptada;
	private LocalDate fecha;
}
