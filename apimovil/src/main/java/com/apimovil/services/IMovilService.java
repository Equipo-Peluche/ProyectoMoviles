package com.apimovil.services;

import java.util.List;

import com.apimovil.models.dto.MovilDTO;
import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.dto.ResumenDTO;
import com.apimovil.models.entities.Movil;

public interface IMovilService {
	public List<ResumenDTO> getMovilesMasVistos(int cantidad);
	public List<MovilDTO> getAllMoviles();
	public List<MovilDTO> getMovilesFilter(MovilFilterRequestDTO movilRequestDTO);
	public boolean createMovil(Movil movil);
	public boolean removeMovil(Movil movil);
	public boolean updateMovil(Movil primerMovil, Movil segundoMovil);
	
}
