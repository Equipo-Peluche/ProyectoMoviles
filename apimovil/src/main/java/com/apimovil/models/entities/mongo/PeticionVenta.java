package com.apimovil.models.entities.mongo;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "PeticionVenta")
public class PeticionVenta extends Peticion<AnuncioVenta>{

	@DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que cero")
	private Double precio;

	public PeticionVenta(User usuario, Boolean aceptada, LocalDate fecha, AnuncioVenta anuncio, Double precio) {
		super(usuario, aceptada, fecha, anuncio);
		this.precio = precio;
	}
	
}
