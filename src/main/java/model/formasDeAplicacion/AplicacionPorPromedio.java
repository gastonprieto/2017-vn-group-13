package model.formasDeAplicacion;

import java.util.Collection;

import model.Empresa;
import model.Periodo;
import model.Condicion.Prioridad.CondicionPrioritaria;
import utils.Converts.GeneradorDePeriodos;

public class AplicacionPorPromedio implements FormaAplicacion {
	
	private int cantPeriodos;
	
	public AplicacionPorPromedio(int cantPeriodos) {
		this.cantPeriodos = cantPeriodos;
	}

	@Override
	public int aplicar(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(this.cantPeriodos);
		int contador = 0;
		double sumatoriaEmpresa1 = 0;
		double sumatoriaEmpresa2 = 0;
		for(Periodo periodo : periodos) {
			contador ++;
			sumatoriaEmpresa1 += condicionPrioritaria.aplicarIndicador(empresa1, periodo);
			sumatoriaEmpresa2 += condicionPrioritaria.aplicarIndicador(empresa2, periodo);
		}
		return condicionPrioritaria.comparar(sumatoriaEmpresa1 / contador, sumatoriaEmpresa2 / contador);
	}
}
