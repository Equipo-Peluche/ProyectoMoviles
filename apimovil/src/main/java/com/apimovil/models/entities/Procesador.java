package com.apimovil.models.entities;

import java.util.ArrayList;
import java.util.List;


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
	private String descripcion;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Movil> movil;
	
	public Procesador(double gigahercios, String descripcion, List<Movil> movil) {
		super();
		this.gigahercios = gigahercios;
		this.descripcion = descripcion;
		this.movil = new ArrayList<>();
	}

}
