package model;

import java.util.Collection;

public class IndicadorSumadoDecorator extends IndicadorDecorator {
	
	public IndicadorSumadoDecorator(Indicador indicador) {
		this.indicador = indicador;
	}
	
	@Override
	public Double aplicar(Empresa empresa, Periodo periodo) {
		return this.indicador.aplicar(empresa, periodo);
	}
	
	public Double promediar(Empresa empresa, Collection<Periodo> periodos) {
		Double sumatoria = 0D;
		for(Periodo periodo : periodos) {
			sumatoria += this.indicador.aplicar(empresa, periodo);
		}
		return sumatoria;
	}
}
