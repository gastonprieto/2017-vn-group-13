package model.condiciones.taxativas;

import javax.persistence.Entity;
import javax.persistence.Transient;

import model.Indicador;
import model.formas.de.aplicacion.FormaAplicacionEnum;

@Entity
public class CondicionCrecienteTaxativa extends CondicionTaxativa {

	@Transient
	private boolean esComparacionInicial = true;
	
	public CondicionCrecienteTaxativa(Indicador indicador, CondicionTaxativa siguienteCondicion, int cantPeriodos) {
		this.indicador = indicador;
		this.formaAplicacion = FormaAplicacionEnum.APLICACION_POR_CONSISTENCIA;
		this.siguienteCondicion = siguienteCondicion;
		this.cantPeriodos = cantPeriodos;
	}
	
	public CondicionCrecienteTaxativa(Indicador indicadorSeleccionado, int cantPeriodos) {
		this.indicador = indicadorSeleccionado;
		this.formaAplicacion = FormaAplicacionEnum.APLICACION_POR_CONSISTENCIA;
		this.cantPeriodos = cantPeriodos;
	}
	
	public CondicionCrecienteTaxativa(){
		super();
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
	
	@Override
	public void reiniciar() {
		this.esComparacionInicial = true;
	}
}
