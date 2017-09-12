package model.condiciones.taxativas;

import model.Indicador;
import model.formas.de.aplicacion.FormaAplicacion;

public class CondicionMenorTaxativa extends CondicionTaxativa {
	
	public CondicionMenorTaxativa(Indicador indicador, FormaAplicacion formaAplicacion,
			CondicionTaxativa siguienteCondicion, double valorReferencia) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.siguienteCondicion = siguienteCondicion;
		this.valorReferencia = valorReferencia;
	}

	@Override
	public boolean comparar(double resultado) {
		return resultado < this.valorReferencia;
	}
}
