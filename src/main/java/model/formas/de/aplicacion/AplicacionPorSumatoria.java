package model.formas.de.aplicacion;

import java.util.Collection;

import model.Empresa;
import model.Periodo;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;
import utils.Converts.GeneradorDePeriodos;

import javax.persistence.*;

@Embeddable
public class AplicacionPorSumatoria extends FormaAplicacion {



	private int cantPeriodos;
	
	public AplicacionPorSumatoria(int cantPeriodos) {
		this.cantPeriodos = cantPeriodos;
	}

	@Override
	public int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(this.cantPeriodos);
		double sumatoriaEmpresa1 = 0;
		double sumatoriaEmpresa2 = 0;
		for(Periodo periodo : periodos) {
			sumatoriaEmpresa1 += condicionPrioritaria.aplicarIndicador(empresa1, periodo);
			sumatoriaEmpresa2 += condicionPrioritaria.aplicarIndicador(empresa2, periodo);
		}
		return condicionPrioritaria.comparar(sumatoriaEmpresa1, sumatoriaEmpresa2);
	}

	@Override
	public boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(this.cantPeriodos);
		double sumatoria = 0;
		for(Periodo periodo : periodos) {
			try{
				sumatoria += condicionTaxativa.aplicarIndicador(empresa, periodo);
			}catch (Exception e){
				return false;
			}
		}
		return condicionTaxativa.comparar(sumatoria);
	}
}
