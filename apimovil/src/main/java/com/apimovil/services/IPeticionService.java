package com.apimovil.services;

import java.util.List;

import com.apimovil.models.dto.mongo.AnuncioRequestDTO;
import com.apimovil.models.dto.mongo.PeticionIntercambioRequestDTO;
import com.apimovil.models.dto.mongo.PeticionResponseDTO;
import com.apimovil.models.dto.mongo.PeticionVentaRequestDTO;
import com.apimovil.models.entities.mongo.PeticionIntercambio;
import com.apimovil.models.entities.mongo.PeticionVenta;
import com.apimovil.models.filters.mongo.IPeticionFilter;

public interface IPeticionService {
	
	public Boolean createPeticionIntercambio(PeticionIntercambioRequestDTO peticion);
	public Boolean createPeticionVenta(PeticionVentaRequestDTO peticion);
	public Boolean confirmarPeticion(PeticionIntercambioRequestDTO peticion);
	public List<PeticionResponseDTO> getAllPeticionesByAnuncio(AnuncioRequestDTO anuncio);
	public List<PeticionResponseDTO> getAll();
	public List<PeticionVenta> getAllPeticionVenta();
	public List<PeticionIntercambio> getAllPeticionIntercambio();
	public List<PeticionResponseDTO> getAllPeticionesByFilterPeticion(IPeticionFilter filter);
	
}
