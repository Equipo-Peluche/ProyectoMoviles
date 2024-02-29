package com.apimovil.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.apimovil.models.entities.mongo.AnuncioVenta;
import com.apimovil.models.entities.mongo.PeticionVenta;
import com.apimovil.models.entities.mongo.User;
import com.apimovil.repositories.mongo.PeticionVentaRepository;

@SpringBootTest
class PeticionVentaRepositoryTest {

	@Autowired
	PeticionVentaRepository peticionVentaRepository;
	@Autowired
	AnuncioVentaRepository anuncioVentaRepository;
	@Autowired
	MongoTemplate mongoTemplate;
	
	@BeforeEach
	void test() {
		mongoTemplate.getCollection("PeticionVenta").drop();
		User usuario = new User("manu@gmail.com","manu","1234");
		AnuncioVenta anuncioVenta = new AnuncioVenta(usuario, "marca", "modelo", 1, 1.0);
		AnuncioVenta anuncioVenta2 = new AnuncioVenta(usuario, "marca", "modelo", 2, 1.0);
		peticionVentaRepository.save(new PeticionVenta(usuario, false, LocalDate.of(2022, 2, 2), anuncioVenta, 1.0));
		peticionVentaRepository.save(new PeticionVenta(usuario, true, LocalDate.of(2021, 2, 2), anuncioVenta2, 100.0));
	}
	
	@Test
	void findByFechaBetween() {
		int expected = 1;
		LocalDate inicio = LocalDate.of(2019, 1, 1);
		LocalDate fin = LocalDate.of(2022, 1, 1);
		Optional<List<PeticionVenta>> byFechaBetween = peticionVentaRepository.findByFechaBetween(inicio, fin);
		assertEquals(expected, byFechaBetween.get().size());
	}

	@Test
	void findByAceptada() {
		int expected = 1;
		boolean aceptada = true;
		Optional<List<PeticionVenta>> byAceptada = peticionVentaRepository.findByAceptada(aceptada);
		assertEquals(expected, byAceptada.get().size());
	}
	
	@Test
	void findByEstado() {
		int expected = 1;
		boolean aceptada = true;
		Optional<List<PeticionVenta>> byAnuncioEstado = peticionVentaRepository.findByAnuncioEstado(1);
		assertEquals(expected, byAnuncioEstado.get().size());
	}
	
	
}
