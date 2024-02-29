package com.apimovil.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import com.apimovil.models.dto.AnuncioResponseDTO;
import com.apimovil.models.mappers.AnuncioIntercambioDTOMapper;
import com.apimovil.models.mappers.AnuncioVentaDTOMapper;
import com.apimovil.repositories.AnuncioVentaRepository;
import com.apimovil.repositories.mongo.AnuncioIntercambioRepository;

public class AnuncioService implements IAnuncioService{

	@Autowired
	AnuncioVentaRepository anuncioVentaRepository;
	@Autowired
	AnuncioIntercambioRepository anuncioIntercambioRepository;
	
	
	@Autowired
	AnuncioIntercambioDTOMapper anuncioIntercambioDTOMapper;
	@Autowired
	AnuncioVentaDTOMapper anuncioVentaDTOMapper;
	
	@Override
	public List<AnuncioResponseDTO> getAllAnuncios() {
		List<AnuncioResponseDTO> result = new ArrayList<>();
		
		result.addAll(anuncioVentaRepository.findAll()
				.stream().map(a -> anuncioVentaDTOMapper.map(a))
				.collect(Collectors.toList())
				);
		
		result.addAll(anuncioIntercambioRepository.findAll()
				.stream().map(a -> anuncioIntercambioDTOMapper.map(a))
				.collect(Collectors.toList())
				);
		
		return result;
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
