package model.formasDeAplicacion;

import model.Empresa;
import model.Condicion.Prioridad.CondicionPrioritaria;

public interface FormaAplicacion {
	int aplicar(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2);
}
