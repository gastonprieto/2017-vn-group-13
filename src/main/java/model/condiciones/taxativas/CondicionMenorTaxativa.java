package model.condiciones.taxativas;

import javax.persistence.Entity;

import model.Indicador;
import model.formas.de.aplicacion.FormaAplicacionEnum;

@Entity
public class CondicionMenorTaxativa extends CondicionTaxativa {
	
	public CondicionMenorTaxativa(Indicador indicador, FormaAplicacionEnum formaAplicacion,
			CondicionTaxativa siguienteCondicion, double valorReferencia, int cantPeriodos) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.siguienteCondicion = siguienteCondicion;
		this.valorReferencia = valorReferencia;
		this.cantPeriodos = cantPeriodos;
	}

	public CondicionMenorTaxativa(Indicador indicador, FormaAplicacionEnum formaAplicacion,
			double valorReferencia, int cantPeriodos) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.valorReferencia = valorReferencia;
		this.cantPeriodos = cantPeriodos;
	}

	@Override
	public boolean comparar(double resultado) {
		return resultado < this.valorReferencia;
	}
}
