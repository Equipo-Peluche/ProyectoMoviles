package com.apimovil.services;

import java.util.List;

import org.bson.types.ObjectId;

import com.apimovil.models.dto.AnuncioIntercambioDTO;
import com.apimovil.models.dto.AnuncioResponseDTO;
import com.apimovil.models.dto.AnuncioVentaDTO;


public interface IAnuncioService {
	public List<AnuncioResponseDTO> getAllAnuncios();
	public List<AnuncioIntercambioDTO> getAnunciosIntercambio();
	public List<AnuncioVentaDTO> getAnunciosVenta();
	public AnuncioResponseDTO getAnuncioByID(String id);
	
	public boolean createAnuncioVenta(AnuncioVentaDTO anuncio);
	public boolean createAnuncioIntercambio(AnuncioIntercambioDTO anuncio);
	
	public boolean removeAnuncio(String id);
	public boolean updateAnuncio(AnuncioResponseDTO newAnuncio);
}
