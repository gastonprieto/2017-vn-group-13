package model;

public class Resta implements Operador {

	public final String simbolo = "-";
	
	@Override
	public Double operar(Operando operandoIzquierdo, Operando operandoDerecho) {
		return operandoIzquierdo.resultado() - operandoDerecho.resultado();
	}
	
	@Override
	public String getSimbolo() {
		return simbolo;
	}
}
