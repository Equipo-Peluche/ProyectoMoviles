package com.apimovil.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.entities.mongo.AnuncioIntercambio;
import com.apimovil.models.entities.mongo.AnuncioVenta;
import com.apimovil.models.entities.mongo.UserEntity;
import com.apimovil.repositories.mongo.AnuncioIntercambioRepository;
@SpringBootTest
class probando {
	@Autowired
	AnuncioIntercambioRepository anuncioIntercambioRepository;
	
	@Autowired
	AnuncioVentaRepository anuncioVentaRepository;

	@Test
	void test() {
		anuncioIntercambioRepository.deleteAll();
		String samsung = "samsung";
		String apple = "apple";
		String xiaomi = "xiaomi";
		String lg = "lg";

		UserEntity user1 = new UserEntity();
		user1.setUsername("usuario1");
		UserEntity user2 = new UserEntity();
		user2.setUsername("usuario2");

		String modeloS10 = "s10";
		String modeloA20 = "A20";
		String trece = "13";

		AnuncioIntercambio anuncioUno = new AnuncioIntercambio(1,user1, xiaomi, "note", 0, 4,false);
		anuncioIntercambioRepository.save(anuncioUno);
		
		int siguienteReferencia = anuncioIntercambioRepository.findFirstByOrderByReferenciaDesc().get().getReferencia()+1;
		AnuncioIntercambio anuncioDos = new AnuncioIntercambio(siguienteReferencia,user2, apple, trece, 0, 5,false);
		anuncioIntercambioRepository.save(anuncioDos);
		
		assertEquals(2, anuncioDos.getReferencia());
		
		
		
		
		
		
		
		
		
		
        // Crear usuarios para los anuncios
        user1 = new UserEntity();
        user1.setUsername("usuario1");
        user2 = new UserEntity();
        user2.setUsername("usuario2");

		Optional<AnuncioVenta> ultimaRef = anuncioVentaRepository.findFirstByOrderByReferenciaDesc();
		assertTrue(!ultimaRef.isEmpty());
		siguienteReferencia=ultimaRef.get().getReferencia()+1;
		
        // Crear anuncios de venta con diferentes precios
        AnuncioVenta anuncio1 = new AnuncioVenta(siguienteReferencia,user1, "Marca1", "Modelo1", 0, 500.0,false);
        
        anuncioVentaRepository.save(anuncio1);
        
        
        assertEquals(3, anuncio1.getReferencia());
        
        
		
		
		
		
		
		
		
	}

}
