package com.apimovil.models.entities;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import jakarta.persistence.CascadeType;
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


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Procesador {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Min(value = 1, message = "El valor no puede ser menor de 1")
	private double gigahercios;
    @NotNull(message = "El nombre del procesador no puede ser nulo")
	private String nombre;
	@OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Movil> movil;
	
	public Procesador(double gigahercios, String nombre) {
		super();
		this.gigahercios = gigahercios;
		this.nombre = nombre;
		this.movil = new ArrayList<>();
	}

}
