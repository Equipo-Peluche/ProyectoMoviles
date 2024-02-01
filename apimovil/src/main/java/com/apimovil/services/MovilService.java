package com.apimovil.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimovil.models.dto.MovilDTO;
import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.dto.ResumenDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.filters.FactoryFilter;
import com.apimovil.models.filters.IFilter;
import com.apimovil.models.mappers.MovilDTOMapper;
import com.apimovil.models.mappers.ResumenDTOMapper;
import com.apimovil.repositories.MovilRepository;

@Service
public class MovilService implements IMovilService {
	
	@Autowired
	MovilRepository movilRepository;
	@Autowired
	ResumenDTOMapper resumenDTOMapper;
	@Autowired
	MovilDTOMapper movilDTOMapper;
	
	@Override
	public List<ResumenDTO> getMovilesMasVistos(int cantidad) {
		
		return movilRepository.findAll().stream().sorted((o1, o2) -> {
			if(o1.getVisitas()<o2.getVisitas()) {
				return -1;
			}else if(o1.getVisitas()>o2.getVisitas()) {
				return 1;
			}
			return 0;
		}).limit(cantidad)
		.map(movil-> resumenDTOMapper.map(movil))
		.collect(Collectors.toList());
	}

	@Override
	public List<MovilDTO> getAllMoviles() {
		return movilRepository.findAll().stream()
				.map(movil -> movilDTOMapper.map(movil))
				.collect(Collectors.toList());
	}

	@Override
	public List<MovilDTO> getMovilesFilter(MovilFilterRequestDTO movilRequestDTO) {
		List<Movil> moviles = movilRepository.findAll();
		List<IFilter> filters = FactoryFilter.ALL.getFilters();
		
		for(IFilter filter:filters) {
			moviles = filter.filter(moviles, movilRequestDTO);
		}
		
		return moviles.stream()
				.map(movil-> movilDTOMapper.map(movil))
				.collect(Collectors.toList());
	}

	@Override
	public boolean createMovil(Movil movil) {
		movilRepository.save(movil);
		return false;
	}

	@Override
	public boolean removeMovil(Movil movil) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateMovil(Movil primerMovil, Movil segundoMovil) {
		if (primerMovil != null || segundoMovil != null) {
			//Aztualizar los campos del primer movil con los del segundo
			primerMovil.setModelo(segundoMovil.getModelo());
			primerMovil.setPrecio(segundoMovil.getPrecio());
			
			// Guardar la actualizacion en el repositorio
			movilRepository.save(primerMovil);
			return true;
		}
		return false;
	}

}
