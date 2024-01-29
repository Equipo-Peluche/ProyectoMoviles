package com.apimovil.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.filters.FactoryFilter;
import com.apimovil.models.filters.IFilter;
import com.apimovil.repositories.MovilRepository;

@Service
public class MovilService implements IMovilService {
	
	@Autowired
	MovilRepository movilRepository;

	@Override
	public List<Movil> getMovilesMasVistos(int cantidad) {
		
		return getAllMoviles().stream().sorted((o1, o2) -> {
			if(o1.getVisitas()<o2.getVisitas()) {
				return -1;
			}else if(o1.getVisitas()>o2.getVisitas()) {
				return 1;
			}
			return 0;
		}).limit(cantidad)
		.collect(Collectors.toList());
	}

	@Override
	public List<Movil> getAllMoviles() {
		return movilRepository.findAll();
	}

	@Override
	public List<Movil> getMovilesFilter(MovilFilterRequestDTO movilRequestDTO) {
		List<Movil> moviles = getAllMoviles();
		List<IFilter> filters = FactoryFilter.ALL.getFilters();
		
		for(IFilter filter:filters) {
			moviles = filter.filter(moviles, movilRequestDTO);
		}
		
		return moviles;
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
		// TODO Auto-generated method stub
		return false;
	}

}
