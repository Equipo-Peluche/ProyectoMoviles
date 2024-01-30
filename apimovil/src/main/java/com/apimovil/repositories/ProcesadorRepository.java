package com.apimovil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apimovil.models.entities.Procesador;

public interface ProcesadorRepository extends JpaRepository<Procesador, Long> {
	
	public List<Procesador> findByGigahercios(double gigaHercios);
	public List<Procesador> findByNombre(String descripcion);
}
