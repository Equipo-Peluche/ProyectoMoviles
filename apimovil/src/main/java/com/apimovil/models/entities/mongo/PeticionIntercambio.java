package com.apimovil.models.entities.mongo;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "PeticionIntercambio")
public class PeticionIntercambio extends Peticion<AnuncioIntercambio> {
	private AnuncioIntercambio anuncioIntercambioSalida;

	public PeticionIntercambio(Integer referencia,UserEntity usuario, Boolean aceptada, LocalDate fecha, AnuncioIntercambio anuncio,
			AnuncioIntercambio anuncioIntercambioSalida) {
		super(referencia,usuario, aceptada, fecha, anuncio);
		this.anuncioIntercambioSalida = anuncioIntercambioSalida;
	}

}
