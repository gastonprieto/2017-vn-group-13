package model;

import java.util.Collection;
import java.util.stream.Stream;

public class CondicionMenor extends CondicionDecorador  {

	public CondicionMenor(double valorDeReferencia, Indicador indicador, Collection<Periodo> periodos) {
		this.valorDeReferencia = valorDeReferencia;
		this.indicador = indicador;
		this.periodos = periodos;
	}

	public CondicionMenor(Indicador indicador, int cantPeriodos){
		this.indicador = indicador;
		this.periodos = this.getPeriodos(cantPeriodos);
	}

	@Override
	public Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas) {
		return streamEmpresas.filter(empresa -> indicador.aplicar(empresa, periodos) < valorDeReferencia);
	}
}
