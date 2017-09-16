package utils.File;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import exception.IndicadorException;
import Parser.Constante;
import Parser.Division;
import model.Indicador;
import Parser.Multiplicacion;
import Parser.Operacion;
import Parser.Operador;
import Parser.Operando;
import Parser.Resta;
import Parser.Suma;
import Parser.Variable;

public class InterpretadorDeIndicadores {
	
	public Indicador interpretar(String nombre, String calculo) {
		if(!calculo.matches("((\\w+)(.\\w+)?[-+*/])*(\\w+)(.\\w+)?") || calculo.contains(nombre)) {
			throw new IndicadorException("La expresion ingresada para el indicador no es valida");
		}
		Indicador indicador = new Indicador(nombre, calculo);
		indicador.setOperacion(this.generarOperando(indicador, calculo));
		return indicador;
	}
	
	private Operando generarOperando(Indicador indicador, String calculo) {
		Operador operador = this.getSiguienteOperador(calculo);
		if(operador != null) {
			return generarOperacion(indicador, calculo, operador);
		}
		if(NumberUtils.isNumber(calculo)) {
			return new Constante(calculo);			
		}
		return new Variable(calculo, indicador);
	}

	private Operacion generarOperacion(Indicador indicador, String calculo, Operador operador) {
		Operando operandoIzq = null;
		String[] operandos = StringUtils.split(calculo, operador.getSimbolo());
		for(String sOperando : operandos) {
			if(operandoIzq == null) {
				operandoIzq = this.generarOperando(indicador, sOperando);
			} else {
				operandoIzq = new Operacion(operandoIzq, operador, this.generarOperando(indicador, sOperando));
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
