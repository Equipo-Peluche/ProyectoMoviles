package com.apimovil.components;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.apimovil.models.entities.Movil;
import com.apimovil.models.om.MovilOM;
import com.apimovil.repositories.MovilRepository;
import com.apimovil.services.MovilService;

@Component
public class Populate {

	private final MovilService movilService;
	private MovilOM movilOM;

	public Populate(MovilService movilService) {
		this.movilService = movilService;
		this.movilOM = new MovilOM();
		populateInsert();
	}

	private void populateInsert() {
		for (Movil movil : movilOM.getData()) {
			movilService.createMovil(movil);
		}
	}
	
}
