package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IndicadorMedioDecorator extends IndicadorDecorator {

	public IndicadorMedioDecorator(Indicador indicador) {
		this.indicador = indicador;
	}
	
	@Override
	public Double aplicar(Empresa empresa, Periodo periodo) {
		return this.indicador.aplicar(empresa, periodo);
	}

	@Override
	public Double aplicar(Empresa empresa, Collection<Periodo> periodos) {
		List<Double> resultados = new ArrayList<>();
		for(Periodo periodo : periodos) {
			resultados.add(this.indicador.aplicar(empresa, periodo));
		}
		return resultados.get(resultados.size() / 2);
	}
}
