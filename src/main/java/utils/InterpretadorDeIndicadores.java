package utils;

import org.apache.commons.lang.StringUtils;

import model.Constante;
import model.Division;
import model.Indicador;
import model.Multiplicacion;
import model.Operacion;
import model.Operador;
import model.Operando;
import model.Resta;
import model.Suma;
import model.Variable;

public class InterpretadorDeIndicadores {
	
	public Operando interpretar(Indicador indicador, String calculo) {
		Operador operador = this.getSiguienteOperador(calculo);
		if(operador != null) {
			return generarOperacion(indicador, calculo, operador);
		}
		if(StringUtils.isNumeric(calculo)) {
			return new Constante(calculo);			
		}
		return new Variable(calculo, indicador);
	}

	private Operacion generarOperacion(Indicador indicador, String calculo, Operador operador) {
		Operando operandoIzq = null;
		String[] operandos = StringUtils.split(calculo, operador.getSimbolo());
		for(String sOperando : operandos) {
			if(operandoIzq == null) {
				operandoIzq = this.interpretar(indicador, sOperando);
			} else {
				operandoIzq = new Operacion(operandoIzq, operador, this.interpretar(indicador, sOperando));
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
