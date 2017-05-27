package model;

public class Resta implements Operador {
	
	@Override
	public Double operar(Double valorIzquierdo, Double valorDerecho) {
		return valorIzquierdo - valorDerecho;
	}
	
	@Override
	public String getSimbolo() {
		return "-";
	}
}
