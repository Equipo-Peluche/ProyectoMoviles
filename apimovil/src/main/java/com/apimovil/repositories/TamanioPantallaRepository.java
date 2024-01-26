package com.apimovil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.TamanioPantalla;

public interface TamanioPantallaRepository extends JpaRepository<TamanioPantalla, Long> {

	// Filtrado de pantallas entre dos pulgadas
	public List<TamanioPantalla> findAllByPulgadasBetween(Double menorTamanio, Double mayorTamanio);

	// Filtrado de poantallas mayor que un un tamaño dado por parametro
	public List<TamanioPantalla> findAllByPulgadasGreaterThan(Double Tamanio);

	// Filtrado de pantallas menor que un tamaño dado por parametro
	public List<TamanioPantalla> findAllByPulgadasLessThan(Double Tamanio);
}
