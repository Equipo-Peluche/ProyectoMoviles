package com.apimovil.services;

import java.util.List;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.dto.UpdateRequestDTO;
import com.apimovil.models.dto.MovilRequestRemoveDTO;
import com.apimovil.models.entities.Movil;

public interface IMovilService {
	public List<Movil> getMovilesMasVistos(int cantidad);
	public List<Movil> getAllMoviles();
	public List<Movil> getMovilesFilter(MovilFilterRequestDTO movilRequestDTO);
	public Movil createMovil(Movil movil);
	public boolean removeMovil(MovilRequestRemoveDTO movilRequestRemoveDTO);
	public boolean updateMovil(UpdateRequestDTO segundoMovil);
	
}
