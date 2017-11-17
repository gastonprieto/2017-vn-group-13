package parser;

import model.Empresa;
import model.Periodo;
import model.Usuario;

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
	public Double resultado(Empresa empresa, Periodo periodo, Usuario usuario) {
		return this.operador.operar(operandoIzquierdo.resultado(empresa, periodo, usuario), operandoDerecho.resultado(empresa, periodo, usuario));
	}
}
