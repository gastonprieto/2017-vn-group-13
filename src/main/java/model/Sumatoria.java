package model;

import java.util.Collection;

public class Sumatoria extends Calculo {
	
	public Sumatoria(Indicador indicador) {
		super(indicador);
	}
	
	@Override
	public Double aplicar(Empresa empresa, Periodo periodo) {
		return this.indicador.aplicar(empresa, periodo);
	}
	
	@Override
	public Double aplicar(Empresa empresa, Collection<Periodo> periodos) {
		Double sumatoria = 0D;
		for(Periodo periodo : periodos) {
			sumatoria += this.indicador.aplicar(empresa, periodo);
		}
		return sumatoria;
	}

}
