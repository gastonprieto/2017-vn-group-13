package model.formas.de.aplicacion;

import model.Empresa;
import model.Condicion.Taxativa.CondicionTaxativa;
import model.condiciones.prioritarias.CondicionPrioritaria;

public interface FormaAplicacion {
	int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2);
	boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa);
}
