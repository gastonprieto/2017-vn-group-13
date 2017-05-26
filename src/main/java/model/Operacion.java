package model;

public class Operacion implements Operando {

	private Operando operandoIzquierdo;
	private Operador operador;
	private Operando operandoDerecho;
	
	public Operacion(Operando operandoIzquierdo, Operador operador, Operando operandoDerecho) {
		this.operandoIzquierdo = operandoIzquierdo;
		this.operador = operador;
		this.operandoDerecho = operandoDerecho;
	}
	
	@Override
	public Double resultado() {
		return this.operador.operar(operandoIzquierdo, operandoDerecho);
	}
}
