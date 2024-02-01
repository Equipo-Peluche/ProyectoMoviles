package com.apimovil.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class TamanioPantalla {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Min(value = 1)
	@Max(value = 15)
	private Double pulgadas;
	@OneToMany
	private List<Movil> listaMoviles;

	public TamanioPantalla(Double pulgadas) {
		super();
		this.pulgadas = pulgadas;
		this.listaMoviles = new ArrayList<>();
	}

}
