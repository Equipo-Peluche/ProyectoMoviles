package com.apimovil.services;

import java.util.List;

import com.apimovil.models.dto.mongo.AnuncioRequestDTO;
import com.apimovil.models.dto.mongo.PeticionIntercambioRequestDTO;
import com.apimovil.models.dto.mongo.PeticionDTO;
import com.apimovil.models.dto.mongo.PeticionVentaRequestDTO;
import com.apimovil.models.entities.mongo.PeticionIntercambio;
import com.apimovil.models.entities.mongo.PeticionVenta;
import com.apimovil.models.filters.mongo.IPeticionFilter;

public class PeticionService implements IPeticionService {

	@Override
	public Boolean createPeticionIntercambio(PeticionIntercambioRequestDTO peticion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean createPeticionVenta(PeticionVentaRequestDTO peticion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean confirmarPeticion(PeticionIntercambioRequestDTO peticion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeticionDTO> getAllPeticionesByAnuncio(AnuncioRequestDTO anuncio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeticionDTO> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeticionVenta> getAllPeticionVenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeticionDTO> getAllPeticionesByFilterPeticion(IPeticionFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeticionIntercambio> getAllPeticionIntercambio() {
		// TODO Auto-generated method stub
		return null;
	}

}
