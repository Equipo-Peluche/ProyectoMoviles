package com.apimovil.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	@OneToMany(mappedBy = "marca")
	public List<Modelo> modelos= new ArrayList<>();
	
	
	
	public Marca(String nombreMarca) {
		this.nombreMarca=nombreMarca;
		
	}
  public void addModelo(Modelo modelo) {
	  this.modelos.add(modelo);
	  
  }
}
