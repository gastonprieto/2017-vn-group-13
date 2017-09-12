package model.condiciones.taxativas;

import model.Indicador;
import model.formas.de.aplicacion.AplicacionPorConsistencia;

public class CondicionCrecienteTaxativa extends CondicionTaxativa {

	private boolean esComparacionInicial = true;
	
	public CondicionCrecienteTaxativa(Indicador indicador, CondicionTaxativa siguienteCondicion, int cantPeriodos) {
		this.indicador = indicador;
		this.formaAplicacion = new AplicacionPorConsistencia(cantPeriodos);
		this.siguienteCondicion = siguienteCondicion;
	}
	
	@Override
	public boolean comparar(double resultado) {
		if(this.esComparacionInicial) {
			this.esComparacionInicial = false;
			this.valorReferencia = resultado;
			return true;
		}
		boolean comparacion = resultado > this.valorReferencia;
		this.valorReferencia = resultado;
		return comparacion;
	}
}
