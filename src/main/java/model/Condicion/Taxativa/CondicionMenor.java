package model.Condicion.Taxativa;

import utils.Converts.ConversorYearToPeriodos;
import model.Calculo.Calculo;
import model.Periodo;
import model.Resultado;
import org.uqbar.commons.utils.Observable;

import java.util.Collection;

@Observable
public class CondicionMenor extends CondicionTaxativa  {

	public CondicionMenor(String name, double valorDeReferencia, int cantidadDePeriodos, Calculo calculo) {
		this.name = name;
		this.valorDeReferencia = valorDeReferencia;
		this.cantidadDePeriodos = cantidadDePeriodos;
		this.calculo = calculo;
	}


	public void aplicar() {
		Collection<Periodo> periodos = new ConversorYearToPeriodos(this.cantidadDePeriodos).Convertir();
		Resultado.getInstance().getResultadoEmpresas().filter(empresa -> this.calculo.aplicar(empresa, periodos) < valorDeReferencia);
	}

}
