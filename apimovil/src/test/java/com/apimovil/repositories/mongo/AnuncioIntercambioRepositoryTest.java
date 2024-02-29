package com.apimovil.repositories.mongo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.entities.Marca;
import com.apimovil.models.entities.mongo.AnuncioIntercambio;
import com.apimovil.models.entities.mongo.UserEntity;

import io.jsonwebtoken.lang.Arrays;

@SpringBootTest
class AnuncioIntercambioRepositoryTest {
	@Autowired
	AnuncioIntercambioRepository anuncioIntercambioRepository;
	
	
	
	@BeforeEach
	void beforeEach() {
		anuncioIntercambioRepository.deleteAll();
	}
	

	@Test
	void testFindByMarca() {
		String samsung = "samsung";
		String apple = "apple";
		String xiaomi = "xiaomi";
		String lg = "lg";

		UserEntity user1 = new UserEntity();
		user1.setUsername("usuario1");
		UserEntity user2 = new UserEntity();
		user2.setUsername("usuario2");

		AnuncioIntercambio anuncioUno = new AnuncioIntercambio(user1, xiaomi, "note", 0, 5);
		AnuncioIntercambio anuncioDos = new AnuncioIntercambio(user2, apple, "note", 0, 5);

		anuncioIntercambioRepository.findByMarca(samsung);
		List<AnuncioIntercambio> anuncios = new ArrayList<>();

		anuncios.add(anuncioUno);
		anuncios.add(anuncioDos);
		anuncioIntercambioRepository.saveAll(anuncios);
		List<AnuncioIntercambio> result = anuncioIntercambioRepository.findByMarca(xiaomi);

		assertEquals(1, result.size());;

	}

	@Test
	void testFindByModelo() {
		String samsung = "samsung";
		String apple = "apple";
		String xiaomi = "xiaomi";
		String lg = "lg";

		String modeloS10 = "s10";
		String modeloA20 = "A20";

		UserEntity user1 = new UserEntity();
		user1.setUsername("usuario1");
		UserEntity user2 = new UserEntity();
		user2.setUsername("usuario2");

		AnuncioIntercambio anuncioUno = new AnuncioIntercambio(user1, xiaomi, "note", 0, 5);
		AnuncioIntercambio anuncioTres = new AnuncioIntercambio(user1, xiaomi, "note", 0, 5);
		AnuncioIntercambio anuncioDos = new AnuncioIntercambio(user2, apple, "note", 0, 5);


		List<AnuncioIntercambio> anuncios = new ArrayList<>();

		anuncios.add(anuncioUno);
		anuncios.add(anuncioDos);
		anuncios.add(anuncioTres);
		
		anuncioIntercambioRepository.saveAll(anuncios);

		List<AnuncioIntercambio> result = anuncioIntercambioRepository.findByModelo("note");

		assertEquals(result.size(),3);

	}

	@Test
	void testFindByEstadoMinimo() {
		String samsung = "samsung";
		String apple = "apple";
		String xiaomi = "xiaomi";
		String lg = "lg";
		
		
		UserEntity user1 = new UserEntity();
		user1.setUsername("usuario1");
		UserEntity user2 = new UserEntity();
		user2.setUsername("usuario2");

		AnuncioIntercambio anuncioUno = new AnuncioIntercambio(user1, xiaomi, "note", 0, 4);
		AnuncioIntercambio anuncioDos = new AnuncioIntercambio(user2, apple, "note", 0, 5);

		List<AnuncioIntercambio> byEstadoMinimo = anuncioIntercambioRepository.findByEstadoMinimo(-3);
		List<AnuncioIntercambio> anuncios = new ArrayList<>();

		anuncios.add(anuncioUno);
		anuncios.add(anuncioDos);
		
		anuncioIntercambioRepository.saveAll(anuncios);
		
		assertEquals(byEstadoMinimo.size(),0);
	
		
	}

	@Test
	void testFindByMarcaAndModelo() {
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
		String trece="13";
		
		
		
		AnuncioIntercambio anuncioUno = new AnuncioIntercambio(user1, xiaomi, "note", 0, 4);
		AnuncioIntercambio anuncioDos = new AnuncioIntercambio(user2, apple, trece, 0, 5);
		AnuncioIntercambio anuncioTres = new AnuncioIntercambio(user2, apple, trece, 0, 5);
		AnuncioIntercambio anuncioCuatro = new AnuncioIntercambio(user2, apple, trece, 0, 5);

		
		
		
		List<AnuncioIntercambio> anuncios = new ArrayList<>();


		anuncios.add(anuncioUno);
		anuncios.add(anuncioDos);
		anuncios.add(anuncioTres);
		anuncios.add(anuncioCuatro);
		anuncioIntercambioRepository.saveAll(anuncios);
		List<AnuncioIntercambio> byEstadoModelo = anuncioIntercambioRepository.findByMarcaAndModelo(apple,trece );
		
		assertEquals(3, byEstadoModelo.size());
		
		
	}

}
