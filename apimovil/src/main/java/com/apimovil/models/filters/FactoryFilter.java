package com.apimovil.models.filters;

import java.util.List;

public enum FactoryFilter {
	ALL(List.of(new PrecioFilter(),new FilterRam()));
	private List<IFilter> filters;
	private FactoryFilter(List<IFilter> filters) {
		this.filters=filters;
	}
	
	public List<IFilter> getFilters() {
		return filters;
	}

}
