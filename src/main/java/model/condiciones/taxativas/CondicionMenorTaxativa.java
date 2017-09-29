package model.condiciones.taxativas;

import model.Indicador;
import model.formas.de.aplicacion.AplicacionForma;
import model.formas.de.aplicacion.FormaAplicacion;

import javax.persistence.Entity;

@Entity
public class CondicionMenorTaxativa extends CondicionTaxativa {
	
	public CondicionMenorTaxativa(Indicador indicador, FormaAplicacion formaAplicacion,
			CondicionTaxativa siguienteCondicion, double valorReferencia, int cantPeriodos,
			AplicacionForma aplicacionForma) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.siguienteCondicion = siguienteCondicion;
		this.valorReferencia = valorReferencia;
		this.cantPeriodos = cantPeriodos;
		this.aplicacionForma = aplicacionForma;
	}

	public CondicionMenorTaxativa(Indicador indicador, FormaAplicacion formaAplicacion,
			double valorReferencia, int cantPeriodos,
			AplicacionForma aplicacionForma) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.valorReferencia = valorReferencia;
		this.cantPeriodos = cantPeriodos;
		this.aplicacionForma = aplicacionForma;
	}

	@Override
	public boolean comparar(double resultado) {
		return resultado < this.valorReferencia;
	}
}
