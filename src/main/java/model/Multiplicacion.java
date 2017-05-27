package model;

public class Multiplicacion implements Operador {

	@Override
	public Double operar(Double valorIzquierdo, Double valorDerecho) {
		return valorIzquierdo * valorDerecho;
	}

	@Override
	public String getSimbolo() {
		return "*";
	}
}
