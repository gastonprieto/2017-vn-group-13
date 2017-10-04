package model.condiciones.taxativas;

import model.Indicador;
import model.formas.de.aplicacion.AplicacionForma;
import model.formas.de.aplicacion.AplicacionPorConsistencia;

import javax.persistence.Entity;

@Entity
public class CondicionDecrecienteTaxativa extends CondicionTaxativa {

	private boolean esComparacionInicial = true;
	
	public CondicionDecrecienteTaxativa(Indicador indicador, CondicionTaxativa siguienteCondicion, int cantPeriodos) {
		this.indicador = indicador;
		this.formaAplicacion = new AplicacionPorConsistencia();
		this.siguienteCondicion = siguienteCondicion;
		this.cantPeriodos = cantPeriodos;
		this.aplicacionForma = AplicacionForma.PORCONSISTENCIA;
	}
	
	public CondicionDecrecienteTaxativa(Indicador indicadorSeleccionado, int cantPeriodos) {
		this.indicador = indicadorSeleccionado;
		this.formaAplicacion = new AplicacionPorConsistencia();
		this.cantPeriodos = cantPeriodos;
		this.aplicacionForma = AplicacionForma.PORCONSISTENCIA;
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
