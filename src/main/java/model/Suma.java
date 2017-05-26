package model;

public class Suma implements Operador {

	private final String simbolo = "+";
	
	@Override
	public Double operar(Operando operandoIzquierdo, Operando operandoDerecho) {
		return operandoIzquierdo.resultado() + operandoDerecho.resultado();
	}

	@Override
	public String getSimbolo() {
		return simbolo;
	}
}
