package com.apimovil.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.entities.mongo.AnuncioVenta;
import com.apimovil.models.entities.mongo.User;
import com.apimovil.repositories.AnuncioVentaRepository;

@SpringBootTest
class AnuncioVentaRepositoryTest {
    @Autowired
    AnuncioVentaRepository anuncioVentaRepository;

    @BeforeEach
    void beforeEach() {
        anuncioVentaRepository.deleteAll();
    }

    @Test
    void testFindByPrecio() {
        // Crear usuarios para los anuncios
        User user1 = new User();
        user1.setUsername("usuario1");
        User user2 = new User();
        user2.setUsername("usuario2");

        // Crear anuncios de venta con diferentes precios
        AnuncioVenta anuncio1 = new AnuncioVenta(user1, "Marca1", "Modelo1", 500.0);
        AnuncioVenta anuncio2 = new AnuncioVenta(user2, "Marca2", "Modelo2", 750.0);
        AnuncioVenta anuncio3 = new AnuncioVenta(user1, "Marca3", "Modelo3", 750.0);
        
        anuncioVentaRepository.save(anuncio1);
        anuncioVentaRepository.save(anuncio2);
        anuncioVentaRepository.save(anuncio3);

        // Buscar anuncios por precio
        List<AnuncioVenta> resultados = anuncioVentaRepository.findByPrecio(750.0).get();

        // Verificar que se encuentren los anuncios esperados
        assertEquals(2, resultados.size());
        assertEquals(750.0, resultados.get(0).getPrecio());
    }
    
    @Test
    void findByMarca() {
        // Crear usuarios para los anuncios
        User user1 = new User();
        user1.setUsername("usuario1");
        User user2 = new User();
        user2.setUsername("usuario2");

        // Crear anuncios de venta con diferentes marcas
        AnuncioVenta anuncio1 = new AnuncioVenta(user1, "Marca1", "Modelo1", 500.0);
        AnuncioVenta anuncio2 = new AnuncioVenta(user2, "Marca2", "Modelo2", 750.0);
        AnuncioVenta anuncio3 = new AnuncioVenta(user1, "Marca3", "Modelo3", 1000.0);
        
        anuncioVentaRepository.save(anuncio1);
        anuncioVentaRepository.save(anuncio2);
        anuncioVentaRepository.save(anuncio3);

        // Buscar anuncios por marca
        List<AnuncioVenta> resultados = anuncioVentaRepository.findByMarca("Marca1").get();

        // Verificar que se encuentren los anuncios esperados
        assertEquals(1, resultados.size());
        assertEquals("Marca1", resultados.get(0).getMarca());
    }
    
    @Test
    void findByModelo() {
        // Crear usuarios para los anuncios
        User user1 = new User();
        user1.setUsername("usuario1");
        User user2 = new User();
        user2.setUsername("usuario2");

        // Crear anuncios de venta con diferentes modelos
        AnuncioVenta anuncio1 = new AnuncioVenta(user1, "Marca1", "Modelo1", 500.0);
        AnuncioVenta anuncio2 = new AnuncioVenta(user2, "Marca2", "Modelo2", 750.0);
        AnuncioVenta anuncio3 = new AnuncioVenta(user1, "Marca3", "Modelo3", 750.0);
        
        anuncioVentaRepository.save(anuncio1);
        anuncioVentaRepository.save(anuncio2);
        anuncioVentaRepository.save(anuncio3);

        // Buscar anuncios por modelo
        List<AnuncioVenta> resultados = anuncioVentaRepository.findByModelo("Modelo3").get();

        // Verificar que se encuentren los anuncios esperados
        assertEquals(1, resultados.size());
        assertEquals("Modelo3", resultados.get(0).getModelo());
    }
    @AfterEach
    void afterEach() {
        anuncioVentaRepository.deleteAll();
    }
}
