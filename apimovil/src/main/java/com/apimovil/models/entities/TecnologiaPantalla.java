package com.apimovil.models.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class TecnologiaPantalla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull(message = "El nombre de tecnología de pantalla no puede ser nula")
	@Column(unique = true)
	private String nombre;
	
	@OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.EAGER, mappedBy = "tecnologiaPantalla")
	@JsonIgnore
	private List<Movil> moviles = new ArrayList<>();
	
	public TecnologiaPantalla(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TecnologiaPantalla [id=" + id + ", nombre=" + nombre + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TecnologiaPantalla other = (TecnologiaPantalla) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}
	
	
}
