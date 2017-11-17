package model.formas.de.aplicacion;

import java.util.Collection;

import model.Empresa;
import model.Periodo;
import model.Usuario;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;
import utils.GeneradorDePeriodos;

public class AplicacionPorPromedio extends FormaAplicacion {	
	
	private static AplicacionPorPromedio instance;
	
	public static AplicacionPorPromedio getInstance() {
		if(instance == null)
			instance = new AplicacionPorPromedio();
		return instance;
	}
	
	private AplicacionPorPromedio() {}
	
	@Override
	public int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2, int cantPeriodos, Usuario usuario) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(cantPeriodos);
		int contador = 0;
		double sumatoriaEmpresa1 = 0;
		double sumatoriaEmpresa2 = 0;
		for(Periodo periodo : periodos) {
			contador ++;
			sumatoriaEmpresa1 += condicionPrioritaria.aplicarIndicador(empresa1, periodo, usuario);
			sumatoriaEmpresa2 += condicionPrioritaria.aplicarIndicador(empresa2, periodo, usuario);
		}
		return condicionPrioritaria.comparar(sumatoriaEmpresa1 / contador, sumatoriaEmpresa2 / contador);
	}

	@Override
	public boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa, int cantPeriodos, Usuario usuario) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(cantPeriodos);
		int contador = 0;
		double sumatoria = 0;
		for(Periodo periodo : periodos) {
			contador ++;
			try {
				sumatoria += condicionTaxativa.aplicarIndicador(empresa, periodo, usuario);
			}catch (Exception e){
				return false;
			}
		}
		return condicionTaxativa.comparar(sumatoria / contador);
	}
}
