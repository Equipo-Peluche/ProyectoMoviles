package com.apimovil.models.entities.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PeticionIntercambio")
public class PeticionIntercambio {
	private AnuncioIntercambio anuncioIntercambioEntrada;
	private AnuncioIntercambio anuncioIntercambioSalida;

}
