package com.apimovil.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.apimovil.models.entities.mongo.AnuncioVenta;

import java.util.List;
import java.util.Optional;

public interface AnuncioVentaRepository extends MongoRepository<AnuncioVenta, ObjectId> {
	public Optional<List<AnuncioVenta>> findByPrecio(double precio);
	public Optional<List<AnuncioVenta>> findByMarca(String marca);
	public Optional<List<AnuncioVenta>> findByModelo(String modelo);
	public Optional<List<AnuncioVenta>> findByEstado(int estado);
	public Optional<AnuncioVenta> findByReferencia(Integer referencia);

}
