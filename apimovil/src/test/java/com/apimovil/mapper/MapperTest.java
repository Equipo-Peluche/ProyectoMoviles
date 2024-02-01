package com.apimovil.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apimovil.models.dto.MovilDTO;
import com.apimovil.models.dto.ResumenDTO;
import com.apimovil.models.entities.Movil;
import com.apimovil.models.mappers.MovilDTOMapper;
import com.apimovil.models.mappers.ResumenDTOMapper;
import com.apimovil.models.om.MovilOM;
import com.apimovil.repositories.MovilRepository;

@SpringBootTest
class MapperTest {
	
	MovilOM movilOM;
	@Autowired
	MovilRepository movilRepository;
	@Autowired
	MovilDTOMapper mapper;
	@Autowired
	ResumenDTOMapper ResumenMapper;
	
	@Test
	void test() {
		movilOM = new MovilOM();
		List<Movil> data = movilOM.getData();
		
//		mapToDTO
		Movil movilUno = data.get(0);
		MovilDTO maptoDTO = mapper.map(movilUno);
		assertEquals(maptoDTO.getRam(), movilUno.getRam());
		
//		mapToResumenDTO
		ResumenDTO resumenDTO = ResumenMapper.map(movilUno);
		assertEquals(resumenDTO.getModelo().getNombre(), movilUno.getNombreModelo());
		
//		mapToEntity (De momento no)
		
		
	}

}
