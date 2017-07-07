package model;

import java.util.Collection;

public interface IndicadorAbstracto {
	Double aplicar(Empresa empresa, Periodo periodo);
	String getNombre();
	Double aplicar(Empresa empresa, Collection<Periodo> periodos);
}