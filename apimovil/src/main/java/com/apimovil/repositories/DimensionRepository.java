package com.apimovil.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apimovil.models.Dimension;
import com.apimovil.models.entities.Movil;

@Repository
public interface DimensionRepository extends JpaRepository<Dimension, Long>{

	public List<Dimension> findByAltoGreaterThanEqual(double alto);
	public List<Dimension> findByAnchoGreaterThanEqual(double ancho);
	public List<Dimension> findByGrosorGreaterThanEqual(double grosor);
	
	
}
