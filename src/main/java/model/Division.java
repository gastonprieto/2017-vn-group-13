package model;

public class Division implements Operador {

	private String simbolo = "/";
	
	@Override
	public Double operar(Operando operandoIzquierdo, Operando operandoDerecho) {
		return operandoIzquierdo.resultado() / operandoDerecho.resultado();
	}

	@Override
	public String getSimbolo() {
		return simbolo;
	}
}
