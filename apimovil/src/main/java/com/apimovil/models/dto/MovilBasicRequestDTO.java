package com.apimovil.models.dto;



import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class MovilBasicRequestDTO {
	@NotNull(message = "La marca no puede ser nulo")
	private String marca;
	@NotNull(message = "El no puede ser nulo")
	private String modelo;
	
	public MovilBasicRequestDTO(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}
	
	

}
