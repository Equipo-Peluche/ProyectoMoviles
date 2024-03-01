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

	public AnuncioVenta( Integer referencia,UserEntity user, String marca, String modelo, int estado, double precio,Boolean isCerrado) {
		super(referencia,user, marca, modelo, estado,isCerrado);
		this.precio = precio;
	}
	
	public String getUsername() {
		return this.getUser().getUsername();
	}


}
