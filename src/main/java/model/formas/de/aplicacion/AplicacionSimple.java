package model.formas.de.aplicacion;

import model.Empresa;
import model.Periodo;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;
import utils.Converts.GeneradorDePeriodos;

public class AplicacionSimple extends FormaAplicacion {

	private static AplicacionSimple instance;
	
	public static AplicacionSimple getInstance() {
		if(instance == null)
			instance = new AplicacionSimple();
		return instance;
	}
	
	private AplicacionSimple() {}

	@Override
	public int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2, int cantPeriodos) {
		Periodo periodo = GeneradorDePeriodos.generarPeriodos(cantPeriodos).iterator().next();
		double resultadoEmpresa1 = condicionPrioritaria.aplicarIndicador(empresa1, periodo);
		double resultadoEmpresa2 = condicionPrioritaria.aplicarIndicador(empresa2, periodo);
		return condicionPrioritaria.comparar(resultadoEmpresa1, resultadoEmpresa2);
	}

	@Override
	public boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa, int cantPeriodos) {
		Periodo periodo = GeneradorDePeriodos.generarPeriodos(cantPeriodos).iterator().next();
		try {
			return condicionTaxativa.comparar(condicionTaxativa.aplicarIndicador(empresa, periodo));
		}catch (Exception e){
			return false;
		}
	}
}
