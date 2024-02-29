package com.apimovil.services;

import java.util.List;

import org.bson.types.ObjectId;

import com.apimovil.models.dto.AnuncioResponseDTO;


public interface IAnuncioService {
	public List<AnuncioResponseDTO> getAllAnuncios();
	public List<AnuncioResponseDTO> getAnuncioByTipo(String tipo);
	public AnuncioResponseDTO getAnuncioByID(String id);
	
	public boolean createAnuncio(AnuncioResponseDTO anuncio);
	public boolean removeAnuncio(String id);
	public boolean updateAnuncio(AnuncioResponseDTO newAnuncio);
}
