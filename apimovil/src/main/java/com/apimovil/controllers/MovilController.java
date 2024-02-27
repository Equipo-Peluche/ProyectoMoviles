package com.apimovil.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.apimovil.models.dto.MovilUpdateRequestDTO;
import com.apimovil.models.dto.MovilBasicRequestDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apimovil.models.dto.MovilDTO;
import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.dto.ResumenDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.services.MovilService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("moviles")
public class MovilController {
	
	private final MovilService movilService;
	
	public MovilController(MovilService movilService) {
		super();
		this.movilService = movilService;
	}

	@RequestMapping("/filter")
	public ResponseEntity<List<MovilDTO>> filter(@Valid @RequestBody MovilFilterRequestDTO movilRequestDTO) {
		List<MovilDTO> moviles = movilService.getMovilesFilter(movilRequestDTO);
		return ResponseEntity.ok(moviles);
	}
	
	@RequestMapping("/top")
	public ResponseEntity<List<ResumenDTO>> getTopFive() {
		List<ResumenDTO> moviles = movilService.getMovilesMasVistos(5);
		return ResponseEntity.ok(moviles);
	}
	

	@PostMapping("/movil")
	public ResponseEntity<Boolean> introducirMovil(@Valid @RequestBody Movil movil) {
		//TODO CAMBIAR E INTRODUCIR BIEN		
		return ResponseEntity.ok(movilService.createMovil(movil));
	}
	@GetMapping
	public ResponseEntity<List<MovilDTO>> getAllMoviles() {
		return ResponseEntity.ok(movilService.getAllMoviles());
	}
	
	@GetMapping("/movil")
	public ResponseEntity<MovilDTO> findByModelo(@Valid @RequestBody MovilBasicRequestDTO updateRequestDTO) {
		return ResponseEntity.ok(movilService.findByRequest(updateRequestDTO));
	}

	@RequestMapping(value = "/movil",method = RequestMethod.PUT)
	public ResponseEntity<Boolean> update(@Valid @RequestBody MovilUpdateRequestDTO updateRequestDTO) {
		return ResponseEntity.ok(movilService.updateMovil(updateRequestDTO));
	}
	
	@DeleteMapping("/movil")
	public ResponseEntity<Boolean> eliminarMovil(@Valid @RequestBody MovilBasicRequestDTO movilRequestRemoveDTO){
		
		return ResponseEntity.ok(movilService.removeMovil(movilRequestRemoveDTO));
		
	}
	
}
