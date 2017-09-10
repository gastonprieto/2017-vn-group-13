package model.formasDeAplicacion;

import java.util.Collection;

import model.Empresa;
import model.Periodo;
import model.Condicion.Prioridad.CondicionPrioritaria;
import utils.Converts.GeneradorDePeriodos;

public class AplicacionSimple implements FormaAplicacion {

	@Override
	public int aplicar(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(1);
		return condicionPrioritaria.comparar(empresa1, empresa2, periodos.iterator().next());
	}
}
