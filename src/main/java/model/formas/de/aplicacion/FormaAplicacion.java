package model.formas.de.aplicacion;

import model.Empresa;
import model.condiciones.prioritarias.CondicionPrioritaria;

public interface FormaAplicacion {
	int aplicar(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2);
}
