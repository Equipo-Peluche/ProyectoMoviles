package com.apimovil.models.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TecnologiaPantalla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	private String nombre;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "tecnologiaPantalla")
	@JsonIgnore
	private List<Movil> moviles = new ArrayList<>();
	
	public TecnologiaPantalla(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public void addMovil(Movil movil) {
		moviles.add(movil);
	}

	@Override
	public String toString() {
		return "TecnologiaPantalla [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
