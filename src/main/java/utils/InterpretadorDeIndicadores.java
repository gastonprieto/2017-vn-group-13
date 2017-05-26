package utils;

import org.apache.commons.lang.StringUtils;

import model.Constante;
import model.Division;
import model.Multiplicacion;
import model.Operacion;
import model.Operador;
import model.Operando;
import model.Resta;
import model.Suma;

public class InterpretadorDeIndicadores {
	
	public Operando interpretar(String indicador) {
		Operador operador = this.getSiguienteOperador(indicador);
		if(operador != null) {
			return generarOperacion(indicador, operador);
		}
		return new Constante(indicador);
	}

	private Operacion generarOperacion(String indicador, Operador operador) {
		Operando operandoIzq = null;
		String[] operandos = StringUtils.split(indicador, operador.getSimbolo());
		for(String sOperando : operandos) {
			if(operandoIzq == null) {
				operandoIzq = this.interpretar(sOperando);
			} else {
				operandoIzq = new Operacion(operandoIzq, operador, this.interpretar(sOperando));
			}
		}
		return (Operacion) operandoIzq;
	}

	private Operador getSiguienteOperador(String indicador) {
		if(indicador.contains("+")) {
			return new Suma();
		} else if(indicador.contains("-")){
			return new Resta();
		} else if(indicador.contains("*")) {
			return new Multiplicacion();
		} else if(indicador.contains("/")) {
			return new Division();
		}
		return null;
	}
}
