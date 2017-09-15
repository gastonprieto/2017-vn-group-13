package model.formas.de.aplicacion;

import model.Empresa;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlEnum;

@Embeddable
@MappedSuperclass
public abstract class FormaAplicacion {



	public abstract int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2);
	public abstract boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa);
}
