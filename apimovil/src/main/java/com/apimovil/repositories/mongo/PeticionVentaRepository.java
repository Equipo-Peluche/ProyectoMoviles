package com.apimovil.repositories.mongo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.apimovil.models.entities.mongo.PeticionVenta;
import com.apimovil.models.entities.mongo.AnuncioIntercambio;
import com.apimovil.models.entities.mongo.AnuncioVenta;


public interface PeticionVentaRepository extends MongoRepository<PeticionVenta, ObjectId>{
	public Optional<List<PeticionVenta>> findByAnuncioEstado(int estado);
	public Optional<List<PeticionVenta>> findByFechaBetween(LocalDate inicio, LocalDate fin);
	public Optional<List<PeticionVenta>> findByAceptada(Boolean aceptada);
	
	
}
