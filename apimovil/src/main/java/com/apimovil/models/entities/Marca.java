package com.apimovil.models.entities;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import jakarta.validation.constraints.*;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Data
@Getter
@Setter
public class Marca {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	@Column(unique = true)
    @NotNull(message = "La marca no puede ser nulo")
	private String nombreMarca;
	
	@OneToMany( cascade = CascadeType.REMOVE ,mappedBy = "marca",fetch = FetchType.EAGER)
	@JsonIgnore
	public List<Modelo> modelos= new ArrayList<>();
	
	
	
	public Marca(String nombreMarca) {
		this.nombreMarca=nombreMarca;
		
	}
  public void addModelo(Modelo modelo) {
	  this.modelos.add(modelo);
	  
  }
}
