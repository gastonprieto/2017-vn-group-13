package model;

import java.util.Collection;
import java.util.stream.Stream;

public class CondicionAscendente extends Condicion {
	
	public CondicionAscendente(Indicador indicador, Collection<Periodo> periodos){
		this.indicador = indicador;
		this.periodos = periodos;
	}

	public CondicionAscendente(Indicador indicador, int cantPeriodos){
		this.indicador = indicador;
		this.periodos = this.getPeriodos(cantPeriodos);
	}
	
	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
		return streamEmpresas.sorted((empresa1, empresa2) ->
			Double.compare(indicador.aplicar(empresa2, periodos), indicador.aplicar(empresa1, periodos)));
	}
}