package com.apimovil.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.entities.Marca;
@SpringBootTest
class MarcaRepositoryTest {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Test
	void test() {
		Marca iphone= new Marca("Iphone");
		Marca oppo= new Marca("Oppo");
		Marca xiaomi= new Marca("Xiaomi");
		Marca motorola= new Marca("Motorola");
		Marca samsumng= new Marca("Samsung");
		Marca htc= new Marca("HTC");
		Marca xiaomiBorrada= new Marca("xiaomiseraborrada");
		
		marcaRepository.save(iphone);
		marcaRepository.save(oppo);
		marcaRepository.save(xiaomi);
		marcaRepository.save(motorola);
		marcaRepository.save(samsumng);
		marcaRepository.save(htc);
		marcaRepository.save(xiaomiBorrada);
		
		
		//Buscar movil por nombre existente
		
		Marca marcaBuscada=marcaRepository.findByNombreMarca("Iphone");
		assertEquals("Iphone", marcaBuscada.getNombreMarca());
		
		// Buscar movil por marca mal escrita
	
		assertNotEquals("iphone", marcaBuscada.getNombreMarca());
		
		//Buscar móvil por marca no registrada
		Marca marcaNoExistente=marcaRepository.findByNombreMarca("chinito");
		
		assertNull(marcaNoExistente);
		
		//Comprobar que existe la marca y una vez borrada compruebo que no existe
		Marca marcaborrar=marcaRepository.findByNombreMarca("xiaomiseraborrada");
		assertEquals("xiaomiseraborrada", marcaborrar.getNombreMarca());
		
		marcaRepository.delete(marcaborrar);
		marcaborrar=marcaRepository.findByNombreMarca("xiaomiseraborrada");
		assertNull(marcaborrar);
		
		
		
	}
	
	

}
