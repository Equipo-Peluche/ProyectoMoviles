package com.apimovil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Long>{
	public List<Modelo> findByNombre(String nombre);
	public List<Modelo> findByMarca(Marca marca);
}
