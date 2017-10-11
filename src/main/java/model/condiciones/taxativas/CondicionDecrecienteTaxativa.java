package model.condiciones.taxativas;

import javax.persistence.Entity;
import javax.persistence.Transient;

import model.Indicador;
import model.formas.de.aplicacion.FormaAplicacionEnum;

@Entity
public class CondicionDecrecienteTaxativa extends CondicionTaxativa {

	@Transient
	private boolean esComparacionInicial = true;
	
	public CondicionDecrecienteTaxativa(Indicador indicador, CondicionTaxativa siguienteCondicion, int cantPeriodos) {
		this.indicador = indicador;
		this.formaAplicacion = FormaAplicacionEnum.AplicacionPorConsistencia;
		this.siguienteCondicion = siguienteCondicion;
		this.cantPeriodos = cantPeriodos;
	}
	
	public CondicionDecrecienteTaxativa(Indicador indicadorSeleccionado, int cantPeriodos) {
		this.indicador = indicadorSeleccionado;
		this.formaAplicacion = FormaAplicacionEnum.AplicacionPorConsistencia;
		this.cantPeriodos = cantPeriodos;
	}
	
	public CondicionDecrecienteTaxativa(){
		super();
	}

	@Override
	public boolean comparar(double resultado) {
		if(this.esComparacionInicial) {
			this.esComparacionInicial = false;
			this.valorReferencia = resultado;
			return true;
		}
		boolean comparacion = resultado < this.valorReferencia;
		this.valorReferencia = resultado;
		return comparacion;
	}
}
