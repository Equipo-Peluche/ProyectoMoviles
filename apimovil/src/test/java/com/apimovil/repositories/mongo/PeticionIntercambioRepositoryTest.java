package com.apimovil.repositories.mongo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.apimovil.models.entities.mongo.AnuncioIntercambio;
import com.apimovil.models.entities.mongo.PeticionIntercambio;
import com.apimovil.models.entities.mongo.PeticionVenta;
import com.apimovil.models.entities.mongo.UserEntity;
import com.apimovil.repositories.AnuncioVentaRepository;

@SpringBootTest
class PeticionIntercambioRepositoryTest {

	@Autowired
	PeticionIntercambioRepository peticionIntercambioRepository;
	@Autowired
	AnuncioIntercambioRepository anuncioIntercambioRepository;
	@Autowired
	MongoTemplate mongoTemplate;

	@BeforeEach
	void test() {
		mongoTemplate.getCollection("PeticionIntercambio").drop();
		UserEntity user = new UserEntity("jesus@gmail.com", "jesus", "1234");
		AnuncioIntercambio intercambioEntrada1 = new AnuncioIntercambio(user, "marca1", "modelo1", 2, 2);
		AnuncioIntercambio intercambioEntrada2 = new AnuncioIntercambio(user, "marca1", "modelo1", 1, 4);
		AnuncioIntercambio intercambioSalida2 = new AnuncioIntercambio(user, "marca2", "modelo2", 3, 4);
		peticionIntercambioRepository.save(
				new PeticionIntercambio(user, true, LocalDate.of(2023, 2, 2), intercambioEntrada1, intercambioSalida2));
		peticionIntercambioRepository.save(
				new PeticionIntercambio(user, true, LocalDate.of(2024, 5, 5), intercambioEntrada2, intercambioSalida2));

	}

	@Test
	void findByFechaBetween() {
		int esperado = 1;
		LocalDate fechaInicio = LocalDate.of(2023, 1, 1);
		LocalDate fechaFin = LocalDate.of(2023, 10, 10);
		Optional<List<PeticionIntercambio>> byFechaBetween = peticionIntercambioRepository
				.findByFechaBetween(fechaInicio, fechaFin);
		assertEquals(esperado, byFechaBetween.get().size());
	}

	@Test
	void findByAceptada() {
		int esperado = 2;
		boolean aceptada = true;
		Optional<List<PeticionIntercambio>> byAceptada = peticionIntercambioRepository.findByAceptada(aceptada);
		assertEquals(esperado, byAceptada.get().size());
	}

	@Test
	void findByEstado() {
		int esperado = 1;
		Optional<List<PeticionIntercambio>> byAnuncioEstado = peticionIntercambioRepository.findByAnuncioEstado(2);
		assertEquals(esperado, byAnuncioEstado.get().size());
	}

}
