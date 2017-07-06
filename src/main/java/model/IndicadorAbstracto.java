package model;

public interface IndicadorAbstracto {
	Double aplicar(Empresa empresa, Periodo periodo);
	String getNombre();
}
