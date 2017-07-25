package model;

import java.util.Collection;

public class Promedio extends Calculo {	

	public Promedio(Indicador indicador) {
		super(indicador);
	}

	@Override
	public Double aplicar(Empresa empresa, Periodo periodo) {
		return this.indicador.aplicar(empresa, periodo);
	}
	
	@Override
	public Double aplicar(Empresa empresa, Collection<Periodo> periodos) {
		Double sumatoria = 0D;
		int contador = 0;
		for(Periodo periodo : periodos) {
			sumatoria += this.indicador.aplicar(empresa, periodo);
			contador ++;
		}
		return sumatoria / contador;
	}

}