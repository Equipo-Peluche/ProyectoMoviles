package com.apimovil.services;

import java.util.List;

import org.bson.types.ObjectId;

import com.apimovil.models.dto.AnuncioResponseDTO;

public class AnuncioService implements IAnuncioService{

	@Override
	public List<AnuncioResponseDTO> getAllAnuncios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AnuncioResponseDTO> getAnuncioByTipo(String tipo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnuncioResponseDTO getAnuncioByID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createAnuncio(AnuncioResponseDTO anuncio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAnuncio(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateAnuncio(AnuncioResponseDTO newAnuncio) {
		// TODO Auto-generated method stub
		return false;
	}

}
