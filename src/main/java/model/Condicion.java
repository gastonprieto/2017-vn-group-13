package model;

import java.util.Collection;
import java.util.stream.Stream;

public abstract class Condicion {
	
	protected Indicador indicador;
	protected Collection<Periodo> periodos;
	
	public abstract Stream<Empresa> aplicar(Stream<Empresa> streamEmpresas);
}
