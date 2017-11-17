package model.formas.de.aplicacion;

import model.Empresa;
import model.Periodo;
import model.Usuario;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;
import utils.GeneradorDePeriodos;

public class AplicacionSimple extends FormaAplicacion {

	private static AplicacionSimple instance;
	
	public static AplicacionSimple getInstance() {
		if(instance == null)
			instance = new AplicacionSimple();
		return instance;
	}
	
	private AplicacionSimple() {}

	@Override
	public int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2, int cantPeriodos, Usuario usuario) {
		Periodo periodo = GeneradorDePeriodos.generarPeriodos(1).iterator().next();
		double resultadoEmpresa1 = condicionPrioritaria.aplicarIndicador(empresa1, periodo, usuario);
		double resultadoEmpresa2 = condicionPrioritaria.aplicarIndicador(empresa2, periodo, usuario);
		return condicionPrioritaria.comparar(resultadoEmpresa1, resultadoEmpresa2);
	}

	@Override
	public boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa, int cantPeriodos, Usuario usuario) {
		Periodo periodo = GeneradorDePeriodos.generarPeriodos(1).iterator().next();
		try {
			return condicionTaxativa.comparar(condicionTaxativa.aplicarIndicador(empresa, periodo, usuario));
		} catch (Exception e) {
			return false;
		}
	}
}
