package model;

public interface Operador {
	public Double operar(Operando operandoIzquierdo, Operando operandoDerecho);
	public String getSimbolo();
}
