package com.apimovil.models.entities;

import jakarta.validation.constraints.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Modelo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	private String nombre;
	@ManyToOne()
	@JoinColumn(name = "marca_id")
    @NotNull(message = "El nombre de modelo no puede ser nulo")
	private Marca marca;
	
	public Modelo(String nombre,Marca marca) {
		this.nombre=nombre;
		this.marca = marca;
	}
	
	public String getNombreMarca() {
		return this.marca.getNombreMarca();
	}
}
