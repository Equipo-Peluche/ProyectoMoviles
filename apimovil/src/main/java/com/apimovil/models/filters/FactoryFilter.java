package com.apimovil.models.filters;

import java.util.List;

public enum FactoryFilter {
	ALL(List.of(new PrecioFilter(),new FilterRam(), new FilterAlmacenamiento(), 
			new FilterBateria(), new FilterCamara(), new FilterMarca(), 
			new FilterModelo(), new FilterScreenSize(), new FilterTecnologiaPantalla(),
			new FilterVisita(), new NFCFilter(), new PesoFilter(), new ProcesadorFilter()));
	private List<IFilter> filters;
	private FactoryFilter(List<IFilter> filters) {
		this.filters=filters;
	}
	
	public List<IFilter> getFilters() {
		return filters;
	}

}
