package com.apimovil.models.entities.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import com.apimovil.models.ERole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "roles")
public class RoleUser {
	@Id
	private String id;
	@Enumerated(EnumType.STRING)
	@Column(unique = true)
	private ERole name;

	public RoleUser(ERole name) {
		super();
		this.name = name;
	}

	
}
