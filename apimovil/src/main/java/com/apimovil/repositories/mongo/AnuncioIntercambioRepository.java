package com.apimovil.repositories.mongo;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.apimovil.models.entities.mongo.AnuncioIntercambio;
import com.apimovil.models.entities.mongo.AnuncioVenta;

public interface AnuncioIntercambioRepository extends MongoRepository<AnuncioIntercambio, ObjectId> {
	public Optional<List<AnuncioIntercambio>> findByMarca(String marca);

	public Optional<List<AnuncioIntercambio>> findByModelo(String modelo);

	public Optional<List<AnuncioIntercambio>> findByEstadoMinimo(int estadominimo);

	public Optional<List<AnuncioIntercambio>> findByMarcaAndModelo(String marca, String modelo);

	 Optional<AnuncioIntercambio> findFirstByOrderByReferenciaDesc();
}
