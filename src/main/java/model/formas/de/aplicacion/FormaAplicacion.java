package model.formas.de.aplicacion;

import model.Empresa;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlEnum;

public abstract class FormaAplicacion {

	public abstract int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2, int cantPeriodos);
	public abstract boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa, int cantPeriodos);
}
