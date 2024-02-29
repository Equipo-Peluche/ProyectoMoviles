package com.apimovil.models.entities.mongo;

import org.bson.types.ObjectId;

import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioVenta extends Anuncio{
	
	@DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que cero")
	private double precio;

	public AnuncioVenta( UserEntity user, String marca, String modelo, int estado, double precio) {
		super(user, marca, modelo, estado);
		this.precio = precio;
	}


}
