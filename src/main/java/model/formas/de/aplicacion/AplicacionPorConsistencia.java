package model.formas.de.aplicacion;

import java.util.ArrayList;
import java.util.Collection;

import model.Empresa;
import model.Periodo;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;
import utils.Converts.GeneradorDePeriodos;

public class AplicacionPorConsistencia implements FormaAplicacion {

	private int cantPeriodos;
	
	public AplicacionPorConsistencia(int cantPeriodos) {
		this.cantPeriodos = cantPeriodos;
	}
	
	@Override
	public int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(this.cantPeriodos);
		Collection<Integer> resultados = new ArrayList<>();
		periodos.stream().forEach((periodo) -> resultados.add(this.aplicarEnUnPeriodo(condicionPrioritaria, empresa1, empresa2, periodo)));
		if(resultados.stream().allMatch((unResultado) -> unResultado == 1))
			return 1;
		else if(resultados.stream().allMatch((unResultado) -> unResultado == -1))
			return -1;
		else
			return 0;
	}

	private Integer aplicarEnUnPeriodo(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2, Periodo periodo) {
		return condicionPrioritaria.comparar(condicionPrioritaria.aplicarIndicador(empresa1, periodo),
				condicionPrioritaria.aplicarIndicador(empresa2, periodo));
	}

	@Override
	public boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(this.cantPeriodos);
		Collection<Boolean> resultados = new ArrayList<>();
		periodos.stream().forEach((periodo) -> resultados.add(condicionTaxativa.comparar(condicionTaxativa.aplicarIndicador(empresa, periodo))));
		condicionTaxativa.reiniciar();
		return resultados.stream().allMatch((unResultado) -> unResultado == true);
	}
}
