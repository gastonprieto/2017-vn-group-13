package model.formas.de.aplicacion;

import java.util.Collection;

import model.Empresa;
import model.Periodo;
import model.Usuario;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;
import utils.GeneradorDePeriodos;

public class AplicacionPorSumatoria extends FormaAplicacion {

	private static AplicacionPorSumatoria instance;
	
	public static AplicacionPorSumatoria getInstance() {
		if(instance == null)
			instance = new AplicacionPorSumatoria();
		return instance;
	}
	
	private AplicacionPorSumatoria() {}

	@Override
	public int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2, int cantPeriodos, Usuario usuario) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(cantPeriodos);
		double sumatoriaEmpresa1 = 0;
		double sumatoriaEmpresa2 = 0;
		for(Periodo periodo : periodos) {
			sumatoriaEmpresa1 += condicionPrioritaria.aplicarIndicador(empresa1, periodo, usuario);
			sumatoriaEmpresa2 += condicionPrioritaria.aplicarIndicador(empresa2, periodo, usuario);
		}
		return condicionPrioritaria.comparar(sumatoriaEmpresa1, sumatoriaEmpresa2);
	}

	@Override
	public boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa, int cantPeriodos, Usuario usuario) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(cantPeriodos);
		double sumatoria = 0;
		for(Periodo periodo : periodos) {
			try{
				sumatoria += condicionTaxativa.aplicarIndicador(empresa, periodo, usuario);
			}catch (Exception e){
				return false;
			}
		}
		return condicionTaxativa.comparar(sumatoria);
	}
}
