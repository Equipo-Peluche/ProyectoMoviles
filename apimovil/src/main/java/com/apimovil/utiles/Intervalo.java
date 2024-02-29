package com.apimovil.utiles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Intervalo<T extends Number> {
	protected T numeroMin;
	protected T numeroMax;
	public abstract boolean isBetween(T number);
	public boolean isAnyFieldNull() {
		return numeroMin==null || numeroMax==null;
	}
	

}
