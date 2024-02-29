package com.apimovil.utiles;


public class IntegerIntervalo extends Intervalo<Integer> {

	
	
	public IntegerIntervalo(Integer numeroMin, Integer numeroMax) {
		super(numeroMin, numeroMax);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isBetween(Integer number) {
		return number>=numeroMin && number<=numeroMax;
	}
	
}
