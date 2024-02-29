package com.apimovil.utiles;


public class DoubleIntervalo extends Intervalo<Double> {
	
	

	public DoubleIntervalo(Double numeroMin, Double numeroMax) {
		super(numeroMin, numeroMax);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isBetween(Double number) {
		return number>=numeroMin && number<=numeroMax;
	}

}
