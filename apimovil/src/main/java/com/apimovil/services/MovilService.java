package com.apimovil.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.Modelo;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.Procesador;
import com.apimovil.models.entities.TamanioPantalla;
import com.apimovil.models.entities.TecnologiaPantalla;
import com.apimovil.models.filters.FactoryFilter;
import com.apimovil.models.filters.IFilter;
import com.apimovil.repositories.MarcaRepository;
import com.apimovil.repositories.ModeloRepository;
import com.apimovil.repositories.MovilRepository;
import com.apimovil.repositories.ProcesadorRepository;
import com.apimovil.repositories.TamanioPantallaRepository;
import com.apimovil.repositories.TecnologiaPantallaRepository;

@Service
public class MovilService implements IMovilService {
	
	@Autowired
	MovilRepository movilRepository;
	
	@Autowired
	MarcaRepository marcaRepository;
	@Autowired
	ModeloRepository modeloRepository;
	@Autowired
	ProcesadorRepository procesadorRepository;
	@Autowired
	TamanioPantallaRepository tamanioPantallaRepository;
	@Autowired
	TecnologiaPantallaRepository tecnologiaPantallaRepository;

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
	public Movil createMovil(Movil movil) {
		Marca marca=movil.getMarca();
		Modelo modelo = movil.getModelo();
		Procesador procesador = movil.getProcesador();
		TamanioPantalla tamanioPantalla = movil.getTamanioPantalla();
		TecnologiaPantalla tecnologiaPantalla = movil.getTecnologiaPantalla();
		
		//Buscar y guardar si existen
		marca = createMarcaIfNotExist(marca);
		modelo.setMarca(marca);
		modelo = createModeloInMarcaIfNotExist(modelo, marca);
		procesador = createProcesadorIfNotExist(procesador);
		tamanioPantalla = createTamanioPantallaIfNotExist(tamanioPantalla);
		tecnologiaPantalla = createTecnologiantallaIfNotExist(tecnologiaPantalla);
		
		//Settear los valores
		movil.setModelo(modelo);
		movil.setProcesador(procesador);
		movil.setTamanioPantalla(tamanioPantalla);
		movil.setTecnologiaPantalla(tecnologiaPantalla);
		Movil save = movilRepository.save(movil);
		return save;
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
	
	
	
	
	
	private Marca createMarcaIfNotExist(Marca marcaInput) {
		Marca marca = marcaRepository.findByNombreMarca(marcaInput.getNombreMarca());
		if(marca==null) {
			marca = marcaRepository.save(marcaInput);
		}
		return marca;
	}
	
	private Modelo createModeloInMarcaIfNotExist(Modelo modeloInput,Marca marcaInput) {
		Modelo modelo = marcaInput.getModelos().stream()
				.filter(modeloIterator->modeloIterator.getNombre().equals(modeloInput.getNombre())).findFirst().orElse(null);
		if(modelo==null) {
			modelo = modeloRepository.save(modeloInput);
		}
		return modelo;
	}
	
	private Procesador createProcesadorIfNotExist(Procesador procesadorInput) {
		Procesador procesador = procesadorRepository.findAll().stream().filter(e->{
			return e.getGigahercios()==procesadorInput.getGigahercios() &&
					e.getNombre().equalsIgnoreCase(e.getNombre());
		}).findFirst().orElse(null);
				
		if(procesador==null) {
			procesador = procesadorRepository.save(procesadorInput);
		}
		
		return procesador;
	}
	private TamanioPantalla createTamanioPantallaIfNotExist(TamanioPantalla tamanioPantInput) {
		TamanioPantalla tamanioPantalla = tamanioPantallaRepository.findByPulgadas(tamanioPantInput.getPulgadas());
				
		if(tamanioPantalla==null) {
			tamanioPantalla = tamanioPantallaRepository.save(tamanioPantInput);
		}
		return tamanioPantalla;
	}
	
	private TecnologiaPantalla createTecnologiantallaIfNotExist(TecnologiaPantalla tecnologiaPantallaInput) {
		TecnologiaPantalla tecnologiaPantalla = tecnologiaPantallaRepository.findByNombre(tecnologiaPantallaInput.getNombre()).stream().findFirst().orElse(null);
				
		if(tecnologiaPantalla==null) {
			tecnologiaPantalla=tecnologiaPantallaRepository.save(tecnologiaPantallaInput);
		}
		return tecnologiaPantalla;
	}
	
	
	
}
