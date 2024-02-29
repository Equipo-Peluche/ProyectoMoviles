package com.apimovil.models.entities.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
public class AnuncioIntercambio extends Anuncio{
	
	private int estadoMinimo;

}
