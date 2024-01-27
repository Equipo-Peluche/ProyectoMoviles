package com.apimovil.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apimovil.models.entities.Movil;

@Repository
public interface MovilRepository extends JpaRepository<Movil, Long>{

	public List<Movil> findByBateriaGreaterThanEqual(int bateria);
	public List<Movil> findByNfc(boolean hasnfc);
	public List<Movil> findByCamaraGreaterThanEqual(double mp);
	public List<Movil> findByDimensiones_AltoGreaterThanEqual(final double alto);
	public List<Movil> findByDimensiones_AnchoGreaterThanEqual(final double ancho);
	public List<Movil> findByDimensiones_GrosorGreaterThanEqual(final double grosor);
	public List<Movil> findByFechaLanzamientoAfter(LocalDate fecha);
	public List<Movil> findByFechaLanzamientoBefore(LocalDate fecha);
	public List<Movil> findByPesoGreaterThanEqual(double peso);
	public List<Movil> findByPrecioGreaterThanEqual(double precio);
	public List<Movil> findByPrecioIsLessThanEqual(double precio);
	public List<Movil> findByPrecioBetween(double precio1, double precio2);
	public List<Movil> findByRamGreaterThanEqual(int ram);
	public List<Movil> findByRam(int ram);
	//TODO PROCESADOR Y PANTALLA FIND BY
	
}
