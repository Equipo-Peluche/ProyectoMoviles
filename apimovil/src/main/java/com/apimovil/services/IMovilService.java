package com.apimovil.services;

import java.util.List;

import com.apimovil.models.dto.MovilDTO;
import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.dto.MovilUpdateRequestDTO;
import com.apimovil.models.dto.MovilBasicRequestDTO;
import com.apimovil.models.dto.ResumenDTO;
import com.apimovil.models.entities.Movil;

public interface IMovilService {
	public List<ResumenDTO> getMovilesMasVistos(int cantidad);
	public List<MovilDTO> getAllMoviles();
	public List<MovilDTO> getMovilesFilter(MovilFilterRequestDTO movilRequestDTO);
	public MovilDTO findByRequest(MovilBasicRequestDTO movilRequestDTO);
	public boolean createMovil(Movil movil);
	public boolean removeMovil(MovilBasicRequestDTO movilRequestRemoveDTO);
	public boolean updateMovil(MovilUpdateRequestDTO segundoMovil);
	
}
