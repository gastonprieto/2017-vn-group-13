package model;

import java.util.Collection;
import java.util.stream.Stream;

public class CondicionMenor extends CondicionTaxativa  {

	public CondicionMenor(double valorDeReferencia, Indicador indicador, Collection<Periodo> periodos) {
		this.valorDeReferencia = valorDeReferencia;
		this.indicador = indicador;
		this.periodos = periodos;
	}

	public CondicionMenor(Indicador indicador, int cantPeriodos){
		this.indicador = indicador;
		ConversorYearToPeriodos Conversor = new ConversorYearToPeriodos(cantPeriodos);
		this.periodos = Conversor.Convertir();
	}

	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
		return streamEmpresas.filter(empresa -> indicador.aplicar(empresa, periodos) < valorDeReferencia);
	}
}
