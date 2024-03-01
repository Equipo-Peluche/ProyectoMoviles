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

		AnuncioIntercambio anuncioUno = new AnuncioIntercambio(1,user1, xiaomi, "note", 0, 5,false);
		AnuncioIntercambio anuncioDos = new AnuncioIntercambio(2,user2, apple, "note", 0, 5,false);

		anuncioIntercambioRepository.findByMarca(samsung);
		List<AnuncioIntercambio> anuncios = new ArrayList<>();

		anuncios.add(anuncioUno);
		anuncios.add(anuncioDos);
		anuncioIntercambioRepository.saveAll(anuncios);
		Optional<List<AnuncioIntercambio>> result = anuncioIntercambioRepository.findByMarca(xiaomi);

		assertEquals(1, result.get().size());
		;

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

		AnuncioIntercambio anuncioUno = new AnuncioIntercambio(3,user1, xiaomi, "note", 0, 5,false);
		AnuncioIntercambio anuncioTres = new AnuncioIntercambio(4,user1, xiaomi, "note", 0, 5,false);
		AnuncioIntercambio anuncioDos = new AnuncioIntercambio(5,user2, apple, "note", 0, 5,false);

		List<AnuncioIntercambio> anuncios = new ArrayList<>();

		anuncios.add(anuncioUno);
		anuncios.add(anuncioDos);
		anuncios.add(anuncioTres);

		anuncioIntercambioRepository.saveAll(anuncios);

		Optional<List<AnuncioIntercambio>> result = anuncioIntercambioRepository.findByModelo("note");

		assertEquals(result.get().size(), 3);

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

		AnuncioIntercambio anuncioUno = new AnuncioIntercambio(6,user1, xiaomi, "note", 0, 4,false);
		AnuncioIntercambio anuncioDos = new AnuncioIntercambio(7,user2, apple, "note", 0, 5,false);

		Optional<List<AnuncioIntercambio>> byEstadoMinimo = anuncioIntercambioRepository.findByEstadoMinimo(-3);
		List<AnuncioIntercambio> anuncios = new ArrayList<>();

		anuncios.add(anuncioUno);
		anuncios.add(anuncioDos);

		anuncioIntercambioRepository.saveAll(anuncios);

		assertEquals(byEstadoMinimo.get().size(), 0);

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
		String trece = "13";

		AnuncioIntercambio anuncioUno = new AnuncioIntercambio(8,user1, xiaomi, "note", 0, 4,false);
		AnuncioIntercambio anuncioDos = new AnuncioIntercambio(9,user2, apple, trece, 0, 5,false);
		AnuncioIntercambio anuncioTres = new AnuncioIntercambio(10,user2, apple, trece, 0, 5,false);
		AnuncioIntercambio anuncioCuatro = new AnuncioIntercambio(11,user2, apple, trece, 0, 5,false);

		List<AnuncioIntercambio> anuncios = new ArrayList<>();

		anuncios.add(anuncioUno);
		anuncios.add(anuncioDos);
		anuncios.add(anuncioTres);
		anuncios.add(anuncioCuatro);
		anuncioIntercambioRepository.saveAll(anuncios);
		Optional<List<AnuncioIntercambio>> byEstadoModelo = anuncioIntercambioRepository.findByMarcaAndModelo(apple, trece);

		assertEquals(3, byEstadoModelo.get().size());

	}

}
