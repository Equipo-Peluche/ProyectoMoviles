package com.apimovil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apimovil.models.entities.TecnologiaPantalla;
import java.util.List;


public interface TecnologiaPantallaRepository extends JpaRepository<TecnologiaPantalla, Long> {
	public List<TecnologiaPantalla> findByNombre(String nombre);
}
