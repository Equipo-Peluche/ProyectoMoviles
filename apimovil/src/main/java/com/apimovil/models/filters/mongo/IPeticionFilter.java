package com.apimovil.models.filters.mongo;

import com.apimovil.models.entities.mongo.Anuncio;
import com.apimovil.models.entities.mongo.Peticion;

public interface IPeticionFilter {
	public boolean filter(Peticion<Anuncio> peticion);
}
