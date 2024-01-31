package com.apimovil.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apimovil.models.mappers.MovilDTOMapper;
import com.apimovil.models.mappers.ResumenDTOMapper;

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
	
}
