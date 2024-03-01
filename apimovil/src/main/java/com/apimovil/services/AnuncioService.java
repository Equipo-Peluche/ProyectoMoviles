package com.apimovil.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimovil.models.dto.AnuncioIntercambioDTO;
import com.apimovil.models.dto.AnuncioResponseDTO;
import com.apimovil.models.dto.AnuncioVentaDTO;
import com.apimovil.models.entities.mongo.AnuncioIntercambio;
import com.apimovil.models.entities.mongo.AnuncioVenta;
import com.apimovil.models.entities.mongo.UserEntity;
import com.apimovil.models.mappers.AnuncioIntercambioDTOMapper;
import com.apimovil.models.mappers.AnuncioVentaDTOMapper;
import com.apimovil.repositories.AnuncioVentaRepository;
import com.apimovil.repositories.UserRepository;
import com.apimovil.repositories.mongo.AnuncioIntercambioRepository;
@Service
public class AnuncioService implements IAnuncioService{

	@Autowired
	AnuncioVentaRepository anuncioVentaRepository;
	@Autowired
	AnuncioIntercambioRepository anuncioIntercambioRepository;
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	AnuncioIntercambioDTOMapper anuncioIntercambioDTOMapper;
	@Autowired
	AnuncioVentaDTOMapper anuncioVentaDTOMapper;
	
	@Override
	public List<AnuncioResponseDTO> getAllAnuncios() {
		List<AnuncioResponseDTO> result = new ArrayList<>();
		
		result.addAll(getAnunciosIntercambio());
		result.addAll(getAnunciosVenta());
		
		return result;
	}

	@Override
	public AnuncioResponseDTO getAnuncioByID(String id) {
		Optional<AnuncioVenta> res1 = anuncioVentaRepository.findById(new ObjectId(id));
		Optional<AnuncioIntercambio> res2 = anuncioIntercambioRepository.findById(new ObjectId(id));
		
		if(res1.isPresent()) return anuncioVentaDTOMapper.map(res1.get());
		if(res2.isPresent()) return anuncioIntercambioDTOMapper.map(res2.get());
		
		return null;
	}

	@Override
	public boolean createAnuncioVenta(AnuncioVentaDTO anuncio) {
		Optional<UserEntity> user = userRepository.findByUsername(anuncio.getUsername());
		
		if(!user.isPresent()) return false;
		
		AnuncioVenta newAnuncio = new AnuncioVenta(
				user.get(),
				anuncio.getMarca(),
				anuncio.getModelo(),
				anuncio.getEstado(),
				anuncio.getPrecio());
		
		anuncioVentaRepository.save(newAnuncio);
		
		return true;
	}

	@Override
	public boolean createAnuncioIntercambio(AnuncioIntercambioDTO anuncio) {
		Optional<UserEntity> user = userRepository.findByUsername(anuncio.getUsername());
		
		if(!user.isPresent()) return false;
		
		AnuncioIntercambio newAnuncio = new AnuncioIntercambio(
				user.get(),
				anuncio.getMarca(),
				anuncio.getModelo(),
				anuncio.getEstado(),
				anuncio.getEstadoMinimo());
		
		anuncioIntercambioRepository.save(newAnuncio);
		
		return true;
	}

	@Override
	public boolean removeAnuncio(String id) {
		Optional<AnuncioVenta> res1 = anuncioVentaRepository.findById(new ObjectId(id));
		Optional<AnuncioIntercambio> res2 = anuncioIntercambioRepository.findById(new ObjectId(id));
		
		if(res1.isPresent()) {
			anuncioVentaRepository.delete(res1.get());
			return true;
		}
		if(res2.isPresent()) {
			anuncioIntercambioRepository.delete(res2.get());
			return true;
		}
		
		return false;
	}

	@Override
	public boolean updateAnuncio(AnuncioResponseDTO newAnuncio) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<AnuncioIntercambioDTO> getAnunciosIntercambio() {
		List<AnuncioIntercambioDTO> result = new ArrayList<>();
		
		result.addAll(anuncioIntercambioRepository.findAll()
				.stream().map(a -> anuncioIntercambioDTOMapper.map(a))
				.collect(Collectors.toList())
				);
		return result;
	}


	@Override
	public List<AnuncioVentaDTO> getAnunciosVenta() {
		List<AnuncioVentaDTO> result = new ArrayList<>();
		
		result.addAll(anuncioVentaRepository.findAll()
				.stream().map(a -> anuncioVentaDTOMapper.map(a))
				.collect(Collectors.toList())
				);
		return result;
	}

	

}
