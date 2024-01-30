package com.apimovil.models.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data						// '@Data' = getters and setters
@NoArgsConstructor			// Constructor sin argumentos
@AllArgsConstructor			// Constructor con argumentos
@Builder
@Entity
public class Procesador {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private double gigahercios;
	private String nombre;
	@OneToMany(fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Movil> movil;
	
	public Procesador(double gigahercios, String nombre) {
		super();
		this.gigahercios = gigahercios;
		this.nombre = nombre;
		this.movil = new ArrayList<>();
	}

}
