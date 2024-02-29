package com.apimovil.repositories.mongo;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.apimovil.models.entities.mongo.AnuncioIntercambio;

public interface AnuncioIntercambioRepository extends MongoRepository<AnuncioIntercambio, ObjectId > {
public List<AnuncioIntercambio> findByMarca(String marca);
public List<AnuncioIntercambio> findByModelo(String modelo);
public List<AnuncioIntercambio> findByEstadoMinimo(int estadominimo);
public List<AnuncioIntercambio> findByMarcaAndModelo(String marca,String modelo);
 
}
