package com.apimovil.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apimovil.models.dto.MovilDTO;
import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.dto.ResumenDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.services.MovilService;

@RestController
@RequestMapping("moviles")
public class MovilController {
	
	private final MovilService movilService;
	
	public MovilController(MovilService movilService) {
		super();
		this.movilService = movilService;
	}

	@RequestMapping("/filter")
	public ResponseEntity<List<MovilDTO>> filter(@Validated @RequestBody MovilFilterRequestDTO movilRequestDTO) {
		List<MovilDTO> moviles = movilService.getMovilesFilter(movilRequestDTO);
		return ResponseEntity.ok(moviles);
	}
	
	@RequestMapping("/top")
	public ResponseEntity<List<ResumenDTO>> getTopFive() {
		List<ResumenDTO> moviles = movilService.getMovilesMasVistos(5);
		return ResponseEntity.ok(moviles);
	}
	

	@PostMapping("/movil")
	public ResponseEntity<Movil> introducirMovil(@RequestBody Movil movil) {
		//TODO CAMBIAR E INTRODUCIR BIEN		
		return ResponseEntity.ok(movilService.createMovil(movil));
	}
	@GetMapping("/movil")
	public ResponseEntity<List<MovilDTO>> getAllMoviles() {
		return ResponseEntity.ok(movilService.getAllMoviles());
	}
	
}
