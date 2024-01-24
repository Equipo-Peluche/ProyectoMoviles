package com.apimovil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apimovil.models.entities.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
	public Marca findByNombreMarca(String marca);

}
