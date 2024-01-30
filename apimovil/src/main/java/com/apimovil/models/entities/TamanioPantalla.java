package com.apimovil.models.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class TamanioPantalla {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	private Double pulgadas;
	@OneToMany
	@JsonIgnore
	private List<Movil> listaMoviles;

	public TamanioPantalla(Double pulgadas) {
		super();
		this.pulgadas = pulgadas;
		this.listaMoviles = new ArrayList<>();
	}

}
