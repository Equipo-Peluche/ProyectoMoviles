package com.apimovil.services;

import java.util.List;

import com.apimovil.models.dto.mongo.AnuncioRequestDTO;
import com.apimovil.models.dto.mongo.PeticionIntercambioRequestDTO;
import com.apimovil.models.dto.mongo.PeticionDTO;
import com.apimovil.models.dto.mongo.PeticionVentaRequestDTO;
import com.apimovil.models.entities.mongo.PeticionIntercambio;
import com.apimovil.models.entities.mongo.PeticionVenta;
import com.apimovil.models.filters.mongo.IPeticionFilter;

public interface IPeticionService {
	
	public Boolean createPeticionIntercambio(PeticionIntercambioRequestDTO peticion);
	public Boolean createPeticionVenta(PeticionVentaRequestDTO peticion);
	public Boolean confirmarPeticion(PeticionIntercambioRequestDTO peticion);
	public List<PeticionDTO> getAllPeticionesByAnuncio(AnuncioRequestDTO anuncio);
	public List<PeticionDTO> getAll();
	public List<PeticionVenta> getAllPeticionVenta();
	public List<PeticionIntercambio> getAllPeticionIntercambio();
	public List<PeticionDTO> getAllPeticionesByFilterPeticion(IPeticionFilter filter);
	
}
