package model;

import java.util.Collection;

public abstract class Calculo {
	
	protected Indicador indicador;
	
	public Calculo(Indicador indicador) {
		this.indicador = indicador;
	}
		
	public abstract Double aplicar(Empresa empresa, Periodo periodo);		
	public abstract Double aplicar(Empresa empresa, Collection<Periodo> periodos);
}
