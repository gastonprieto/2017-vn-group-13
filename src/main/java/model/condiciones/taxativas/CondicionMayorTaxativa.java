package model.condiciones.taxativas;

import javax.persistence.Entity;

import model.Indicador;
import model.formas.de.aplicacion.FormaAplicacionEnum;

@Entity
public class CondicionMayorTaxativa extends CondicionTaxativa {
	
	public CondicionMayorTaxativa(){
		super();
	}
	
	public CondicionMayorTaxativa(Indicador indicador, FormaAplicacionEnum formaAplicacion,
			CondicionTaxativa siguienteCondicion, double valorReferencia, int cantPeriodos) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.siguienteCondicion = siguienteCondicion;
		this.valorReferencia = valorReferencia;
		this.cantPeriodos = cantPeriodos;
	}

	public CondicionMayorTaxativa(Indicador indicador, FormaAplicacionEnum formaAplicacion,
			double valorReferencia, int cantPeriodos) {
		this.indicador = indicador;
		this.formaAplicacion = formaAplicacion;
		this.valorReferencia = valorReferencia;
		this.cantPeriodos = cantPeriodos;
	}

	@Override
	public boolean comparar(double resultado) {
		return resultado > this.valorReferencia;
	}
}
