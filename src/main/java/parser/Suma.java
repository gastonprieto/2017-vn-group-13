package parser;

public class Suma implements Operador {
	
	@Override
	public Double operar(Double valorIzquierdo, Double valorDerecho) {
		return valorIzquierdo + valorDerecho;
	}

	@Override
	public String getSimbolo() {
		return "+";
	}
}
