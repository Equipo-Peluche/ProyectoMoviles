package com.apimovil.repositories.mongo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.apimovil.models.entities.mongo.PeticionIntercambio;

public interface PeticionIntercambioRepository extends MongoRepository<PeticionIntercambio, ObjectId> {
	public Optional<List<PeticionIntercambio>> findByAceptada(boolean hasaceptada);
	public Optional<List<PeticionIntercambio>> findBetweenDates(LocalDate fechaUno, LocalDate fechaDos);
}
