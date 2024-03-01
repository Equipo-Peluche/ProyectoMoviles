package com.apimovil.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apimovil.models.dto.AnuncioIntercambioDTO;
import com.apimovil.models.dto.AnuncioResponseDTO;
import com.apimovil.models.dto.AnuncioVentaDTO;
import com.apimovil.services.AnuncioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("anuncios")
public class AnunciosController {
	
	@Autowired
	AnuncioService anuncioService;

	@GetMapping("/crearanuncio")
	public ResponseEntity<?> getCrearAnuncioVenta(@Valid @RequestBody AnuncioVentaDTO anuncio) {
		Boolean response=anuncioService.createAnuncioVenta(anuncio);
		if(response) {
			return ResponseEntity.ok(true);	
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/crearanuncio")
	public ResponseEntity<?> getCrearAnuncioIntercambio(@Valid @RequestBody AnuncioIntercambioDTO anuncio) {
		Boolean response=anuncioService.createAnuncioIntercambio(anuncio);
		if(response) {
			return ResponseEntity.ok(true);	
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	@GetMapping("/getbyid")
	public ResponseEntity<?> getAnuncioByID(@Valid @RequestParam String id) {
		AnuncioResponseDTO anuncioResponse = anuncioService.getAnuncioByID(id);
		if(anuncioResponse!=null) {
			return ResponseEntity.ok(anuncioResponse);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/remove")
	public ResponseEntity<?> removeAnuncio(@Valid @RequestParam String id) {
		Boolean response = anuncioService.removeAnuncio(id);
		if(response) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> updateAnuncio(@Valid @RequestParam String id) {
		Boolean response = anuncioService.removeAnuncio(id);
		if(response) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.badRequest().build();
	}
	
}
