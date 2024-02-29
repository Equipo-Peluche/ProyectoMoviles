package com.apimovil.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dimension{
	
	public Dimension(double alto, double ancho, double grosor) {
		super();
		this.alto = alto;
		this.ancho = ancho;
		this.grosor = grosor;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private double alto;
	private double ancho;
	private double grosor;
	
}
