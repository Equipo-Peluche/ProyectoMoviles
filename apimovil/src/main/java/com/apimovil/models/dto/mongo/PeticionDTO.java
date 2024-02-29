package com.apimovil.models.dto.mongo;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Field;

import com.apimovil.models.dto.AnuncioResponseDTO;
import com.apimovil.models.entities.mongo.UserEntity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class PeticionDTO {

	private String usuario;
	private Boolean aceptada;
	private LocalDate fecha;
	private AnuncioResponseDTO anuncio;
	
}
