package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Mediana extends Calculo {
	
	public Mediana(Indicador indicador) {
		super(indicador);
	}
	
	@Override
	public Double aplicar(Empresa empresa, Periodo periodo) {
		return this.indicador.aplicar(empresa, periodo);
	}

	@Override
	public Double aplicar(Empresa empresa, Collection<Periodo> periodos) {
		List<Double> resultados = new ArrayList<>();
		Double valor = 0.0;
		for(Periodo periodo : periodos) {
			try{
				valor = this.indicador.aplicar(empresa, periodo);
				resultados.add(valor);
			}catch (NullPointerException e){
				valor = 0.0;
				// y no agrego nada... n ose si esta bien.... pero por lo menos deberia tirar error por ahora.
			}
		}
		return resultados.get(resultados.size() / 2);
	}

}
