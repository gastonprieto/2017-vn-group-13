package model.formas.de.aplicacion;

import model.Empresa;
import model.Periodo;
import model.Condicion.Taxativa.CondicionTaxativa;
import model.condiciones.prioritarias.CondicionPrioritaria;
import utils.Converts.GeneradorDePeriodos;

public class AplicacionSimple implements FormaAplicacion {

	@Override
	public int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2) {
		Periodo periodo = GeneradorDePeriodos.generarPeriodos(1).iterator().next();
		double resultadoEmpresa1 = condicionPrioritaria.aplicarIndicador(empresa1, periodo);
		double resultadoEmpresa2 = condicionPrioritaria.aplicarIndicador(empresa2, periodo);
		return condicionPrioritaria.comparar(resultadoEmpresa1, resultadoEmpresa2);
	}

	@Override
	public boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa) {
		Periodo periodo = GeneradorDePeriodos.generarPeriodos(1).iterator().next();
		return condicionTaxativa.comparar(condicionTaxativa.aplicarIndicador(empresa, periodo));
	}
}
