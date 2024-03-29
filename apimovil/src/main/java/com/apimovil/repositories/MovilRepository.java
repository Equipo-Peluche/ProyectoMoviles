package com.apimovil.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;

@Repository
public interface MovilRepository extends JpaRepository<Movil, Long>{

	public List<Movil> findByBateriaGreaterThanEqual(int bateria);
	public List<Movil> findByNfc(boolean hasnfc);
	public List<Movil> findByCamaraGreaterThanEqual(double mp);
	public List<Movil> findByAltoGreaterThanEqual(final double alto);
	public List<Movil> findByAnchoGreaterThanEqual(final double ancho);
	public List<Movil> findByGrosorGreaterThanEqual(final double grosor);
	public List<Movil> findByFechaLanzamientoAfter(LocalDate fecha);
	public List<Movil> findByFechaLanzamientoBefore(LocalDate fecha);
	public List<Movil> findByPesoGreaterThanEqual(double peso);
	public List<Movil> findByPrecioGreaterThanEqual(double precio);
	public List<Movil> findByPrecioIsLessThanEqual(double precio);
	public List<Movil> findByPrecioBetween(double precio1, double precio2);
	public List<Movil> findByRamGreaterThanEqual(int ram);
	public List<Movil> findByRam(int ram);
	public Movil findByModelo(Modelo modelo);
	public void delete(Movil movil);
	//TODO PROCESADOR Y PANTALLA FIND BY
	
}
