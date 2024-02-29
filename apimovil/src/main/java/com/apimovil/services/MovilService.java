package com.apimovil.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.apimovil.models.dto.MovilDTO;
import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.dto.MovilUpdateRequestDTO;
import com.apimovil.models.dto.MovilBasicRequestDTO;
import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.Modelo;
import com.apimovil.models.dto.ResumenDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.entities.Procesador;
import com.apimovil.models.entities.TamanioPantalla;
import com.apimovil.models.entities.TecnologiaPantalla;
import com.apimovil.models.filters.FactoryFilter;
import com.apimovil.models.filters.IFilter;
import com.apimovil.repositories.MarcaRepository;
import com.apimovil.repositories.ModeloRepository;
import com.apimovil.models.mappers.MovilDTOMapper;
import com.apimovil.models.mappers.ResumenDTOMapper;
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
	public MovilDTO findByRequest(MovilBasicRequestDTO movilRequestDTO) {
		Optional<Modelo> modelo = getModeloByNombreMarcaAndNombreModel(movilRequestDTO);
		if(modelo.isPresent()) {
			Movil movilModificar = movilRepository.findByModelo(modelo.get());
			movilModificar.aumentarVisita();
			movilRepository.save(movilModificar);
			return movilDTOMapper.map(movilModificar);			
		}
		return null;
	}

	@Override
	public boolean createMovil(Movil movil) {
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
		return save!=null;
	}


	@Override
	public boolean removeMovil(MovilBasicRequestDTO movilRequestRemoveDTO) {
		Optional<Modelo> modelo = getModeloByNombreMarcaAndNombreModel(movilRequestRemoveDTO);
		if(modelo.isPresent()) {
			
			Movil movil = movilRepository.findByModelo(modelo.get());
			movilRepository.delete(movil);
			
			
			
			return true;
		}
		
		
		return false;
	}

	@Override
	public boolean updateMovil(MovilUpdateRequestDTO updateRequestDTO) {
		
		Optional<Modelo> modelo = getModeloByNombreMarcaAndNombreModel(updateRequestDTO);
		if(modelo.isPresent()) {
			Movil movil=movilRepository.findByModelo(modelo.get());
			movil.setPrecio(updateRequestDTO.getPrecio());
			movilRepository.save(movil);
			return true;
		}
		return false;
	}
	
	private Optional<Modelo> getModeloByNombreMarcaAndNombreModel(MovilBasicRequestDTO basicRequestDTO) {
		return getModeloByNombreMarcaAndNombreModel(basicRequestDTO.getMarca(),basicRequestDTO.getModelo());
	}
	
	private Optional<Modelo> getModeloByNombreMarcaAndNombreModel(MovilUpdateRequestDTO updateRequestDTO) {
		return getModeloByNombreMarcaAndNombreModel(updateRequestDTO.getMarca(),updateRequestDTO.getModelo());
	}

	private Optional<Modelo> getModeloByNombreMarcaAndNombreModel(String nombreMarca, String nombreModelo) {
		return marcaRepository.findByNombreMarcaIgnoreCase(nombreMarca).getModelos().stream()
				.filter(e->e.getNombre().equalsIgnoreCase(nombreModelo))
				.findFirst();

	}
	
	private Marca createMarcaIfNotExist(Marca marcaInput) {
		Marca marca = marcaRepository.findByNombreMarcaIgnoreCase(marcaInput.getNombreMarca());
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
		TecnologiaPantalla tecnologiaPantalla = tecnologiaPantallaRepository.findByNombre(tecnologiaPantallaInput.getNombre());
				
		if(tecnologiaPantalla==null) {
			tecnologiaPantalla=tecnologiaPantallaRepository.save(tecnologiaPantallaInput);
		}
		return tecnologiaPantalla;
	}
	
	
	
	
}
