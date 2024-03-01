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
import com.apimovil.models.entities.mongo.UserEntity;
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
        UserEntity user1 = new UserEntity();
        user1.setUsername("usuario1");
        UserEntity user2 = new UserEntity();
        user2.setUsername("usuario2");

        // Crear anuncios de venta con diferentes precios
        AnuncioVenta anuncio1 = new AnuncioVenta(1,user1, "Marca1", "Modelo1", 0, 500.0,false);
        AnuncioVenta anuncio2 = new AnuncioVenta(2,user2, "Marca2", "Modelo2", 1, 750.0,false);
        AnuncioVenta anuncio3 = new AnuncioVenta(3,user1, "Marca3", "Modelo3", 2, 750.0,false);
        
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
        UserEntity user1 = new UserEntity();
        user1.setUsername("usuario1");
        UserEntity user2 = new UserEntity();
        user2.setUsername("usuario2");

        // Crear anuncios de venta con diferentes marcas
        AnuncioVenta anuncio1 = new AnuncioVenta(4,user1, "Marca1", "Modelo1", 0, 500.0,false);
        AnuncioVenta anuncio2 = new AnuncioVenta(5,user2, "Marca2", "Modelo2", 1, 750.0,false);
        AnuncioVenta anuncio3 = new AnuncioVenta(6,user1, "Marca3", "Modelo3", 2, 1000.0,false);
        
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
        UserEntity user1 = new UserEntity();
        user1.setUsername("usuario1");
        UserEntity user2 = new UserEntity();
        user2.setUsername("usuario2");

        // Crear anuncios de venta con diferentes modelos
        AnuncioVenta anuncio1 = new AnuncioVenta(7,user1, "Marca1", "Modelo1", 0, 500.0,false);
        AnuncioVenta anuncio2 = new AnuncioVenta(8,user2, "Marca2", "Modelo2", 0, 750.0,false);
        AnuncioVenta anuncio3 = new AnuncioVenta(9,user1, "Marca3", "Modelo3", 0, 1000.0,false);
        
        anuncioVentaRepository.save(anuncio1);
        anuncioVentaRepository.save(anuncio2);
        anuncioVentaRepository.save(anuncio3);

        // Buscar anuncios por modelo
        List<AnuncioVenta> resultados = anuncioVentaRepository.findByModelo("Modelo3").get();

        // Verificar que se encuentren los anuncios esperados
        assertEquals(1, resultados.size());
        assertEquals("Modelo3", resultados.get(0).getModelo());
    }

    @Test
    void findByEstado() {
        // Crear usuarios para los anuncios
        UserEntity user1 = new UserEntity();
        user1.setUsername("usuario1");
        UserEntity user2 = new UserEntity();
        user2.setUsername("usuario2");

        // Crear anuncios de venta con diferentes estados
        AnuncioVenta anuncio1 = new AnuncioVenta(10,user1, "Marca1", "Modelo1", 0, 500.0,false);
        AnuncioVenta anuncio2 = new AnuncioVenta(11,user2, "Marca2", "Modelo2", 1, 750.0,false);
        AnuncioVenta anuncio3 = new AnuncioVenta(12,user1, "Marca3", "Modelo3", 2, 1000.0,false);
        
        anuncioVentaRepository.save(anuncio1);
        anuncioVentaRepository.save(anuncio2);
        anuncioVentaRepository.save(anuncio3);

        // Buscar anuncios por estado
        List<AnuncioVenta> resultados = anuncioVentaRepository.findByEstado(2).get();

        // Verificar que se encuentren los anuncios esperados
        assertEquals(1, resultados.size());
        assertEquals(2, resultados.get(0).getEstado());
    }
    @AfterEach
    void afterEach() {
        anuncioVentaRepository.deleteAll();
    }
    
    
}
