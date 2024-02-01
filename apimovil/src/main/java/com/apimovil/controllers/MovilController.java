package com.apimovil.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.apimovil.models.dto.MovilFilterRequestDTO;
import com.apimovil.models.dto.UpdateRequestDTO;
import com.apimovil.models.dto.MovilRequestRemoveDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.services.MovilService;

@RestController
@RequestMapping("moviles")
public class MovilController {
	
	@Autowired
	MovilService movilService;
	
	@RequestMapping("/filter")
	public ResponseEntity<List<Movil>> filter(@Validated @RequestBody MovilFilterRequestDTO movilRequestDTO) {
		List<Movil> moviles = movilService.getMovilesFilter(movilRequestDTO);
		return ResponseEntity.ok(moviles);
	}
	
	@RequestMapping("/top")
	public ResponseEntity<List<Movil>> getTopFive() {
		//TODO hacer el Mapper y DTO Resumen
		List<Movil> moviles = movilService.getMovilesMasVistos(5);
		return ResponseEntity.ok(moviles);
	}
	

	@PostMapping("/movil")
	public ResponseEntity<Movil> introducirMovil(@RequestBody Movil movil) {
		System.out.println();
		//TODO CAMBIAR E INTRODUCIR BIEN		
		return ResponseEntity.ok(movilService.createMovil(movil));
	}
	@GetMapping("/movil")
	public ResponseEntity<List<Movil>> getAllMoviles() {
		return ResponseEntity.ok(movilService.getAllMoviles());
	}
	@RequestMapping(value = "/movil",method = RequestMethod.PUT)
	public ResponseEntity<Boolean> update(@RequestBody UpdateRequestDTO updateRequestDTO) {
		return ResponseEntity.ok(movilService.updateMovil(updateRequestDTO));
	}
	
	@DeleteMapping("/movil")
	public ResponseEntity<Boolean> eliminarMovil(@RequestBody MovilRequestRemoveDTO movilRequestRemoveDTO){
		
		return ResponseEntity.ok(movilService.removeMovil(movilRequestRemoveDTO));
		
		
	}
	
}
