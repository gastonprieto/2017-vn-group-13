package model;

import org.uqbar.commons.utils.Observable;

import java.util.Collection;
import java.util.stream.Stream;

@Observable
public class CondicionDecreciente extends CondicionPrioridad {

	public CondicionDecreciente(String name, Indicador indicador, Collection<Periodo> periodos){
		this.name = name;
		this.indicador = indicador;
		this.periodos = periodos;
	}

	public CondicionDecreciente(Indicador indicador, int cantPeriodos){
		this.indicador = indicador;
		ConversorYearToPeriodos Conversor = new ConversorYearToPeriodos(cantPeriodos);
		this.periodos = Conversor.Convertir();
	}

	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
		return streamEmpresas.sorted((empresa1, empresa2) ->
				Double.compare(indicador.aplicar(empresa2, periodos), indicador.aplicar(empresa1, periodos)));
	}
}