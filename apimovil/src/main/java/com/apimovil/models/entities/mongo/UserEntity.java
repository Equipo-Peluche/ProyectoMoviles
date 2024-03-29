package com.apimovil.models.entities.mongo;

import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "users")
public class UserEntity {
	@Id
	private String id;
	@Email(message = "no cumple el formato")
	@NotBlank(message = "no puede estar en blanco")
	@Size(max = 80, message = "email demasiado largo")
	private String email;
	@NotBlank(message = "no puede estar en blanco")
	@Size(max = 30, message = "demasiado grande tu username")
	@Indexed(unique = true, background = true)
	private String username;
	@NotBlank(message = "no puede estar en blanco")
	private String password;


	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private Set<RoleUser> roles;
	
	public UserEntity(String email, String username, String password) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
	}

}
