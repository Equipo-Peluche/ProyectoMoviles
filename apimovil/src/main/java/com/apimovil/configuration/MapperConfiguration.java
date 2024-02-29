package com.apimovil.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apimovil.models.mappers.AnuncioIntercambioDTOMapper;
import com.apimovil.models.mappers.AnuncioVentaDTOMapper;
import com.apimovil.models.mappers.MovilDTOMapper;
import com.apimovil.models.mappers.ResumenDTOMapper;
import com.apimovil.models.mappers.UserCreateDTO2UserMapper;

@Configuration
public class MapperConfiguration {
    @Bean
    MovilDTOMapper getMovilMapper() {
		return new MovilDTOMapper();
	}
	@Bean
	ResumenDTOMapper getResumenDTOMapper() {
		return new ResumenDTOMapper();
	}
	
	@Bean
	UserCreateDTO2UserMapper getUserCreateDTO2UserMapper() {
		return new UserCreateDTO2UserMapper();
	}
	
	@Bean
	AnuncioIntercambioDTOMapper getAnuncioIntercambioDTOMapper() {
		return new AnuncioIntercambioDTOMapper();
	}
	
	@Bean
	AnuncioVentaDTOMapper getAnuncioVentaDTOMapper() {
		return new AnuncioVentaDTOMapper();
	}
	
}
