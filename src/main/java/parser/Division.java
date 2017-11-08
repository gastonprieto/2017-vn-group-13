package parser;

public class Division implements Operador {
	
	@Override
	public Double operar(Double valorIzquierdo, Double valorDerecho) {
		return valorIzquierdo / valorDerecho;
	}

	@Override
	public String getSimbolo() {
		return "/";
	}
}
