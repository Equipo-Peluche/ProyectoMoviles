package com.apimovil.models.entities;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class TamanioPantalla {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	@Min(value = 1)
	@Max(value = 15)
	private Double pulgadas;
	@OneToMany(cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<Movil> listaMoviles;

	public TamanioPantalla(Double pulgadas) {
		super();
		this.pulgadas = pulgadas;
		this.listaMoviles = new ArrayList<>();
	}

}
