package com.apimovil.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.services.MovilService;

@RestController
@RequestMapping("moviles")
public class MovilController {
	
	@Autowired
	MovilService movilService;
	
	@RequestMapping("/filter")
	public ResponseEntity<List<Movil>> filter(@RequestBody MovilFilterRequestDTO movilRequestDTO) {
		List<Movil> moviles = movilService.getMovilesFilter(movilRequestDTO);
		return ResponseEntity.ok(moviles);
	}
	
	@RequestMapping("/top")
	public ResponseEntity<List<Movil>> getTopFive() {
		List<Movil> moviles = movilService.getMovilesMasVistos(5);
		return ResponseEntity.ok(moviles);
	}
	
	@RequestMapping(value="/movil", method = RequestMethod.POST)
	public ResponseEntity<String> introducirMovil() {
		//TODO CAMBIAR E INTRODUCIR BIEN
		//movilService.createMovil(new Movil(128, 8, 213.2, 33, 4100, true, 313, LocalDate.now(), null));
		//movilService.createMovil(new Movil(64, 4, 177.2, 33, 3090, false, 199, LocalDate.now(), null));
		//movilService.createMovil(new Movil(256, 12, 256.2, 33, 5900, true, 414, LocalDate.now(), null));
		
		return ResponseEntity.ok("Creado");
	}
	
}
