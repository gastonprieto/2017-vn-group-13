package model.formas.de.aplicacion;

import model.Empresa;
import model.Usuario;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;

public abstract class FormaAplicacion {

	public abstract int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2, int cantPeriodos, Usuario usuario);
	public abstract boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa, int cantPeriodos, Usuario usuario);
}
