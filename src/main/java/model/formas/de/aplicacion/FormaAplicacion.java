package model.formas.de.aplicacion;

import model.Empresa;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;

import javax.persistence.*;

public interface FormaAplicacion {
	int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2);
	boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa);
}
