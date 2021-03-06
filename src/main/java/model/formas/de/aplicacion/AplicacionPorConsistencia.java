package model.formas.de.aplicacion;

import java.util.ArrayList;
import java.util.Collection;

import model.Empresa;
import model.Periodo;
import model.Usuario;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;
import utils.GeneradorDePeriodos;

public class AplicacionPorConsistencia extends FormaAplicacion {	
	
	private static AplicacionPorConsistencia instance;
	
	public static AplicacionPorConsistencia getInstance() {
		if(instance == null)
			instance = new AplicacionPorConsistencia();
		return instance;
	}
	
	private AplicacionPorConsistencia() {}
	
	@Override
	public int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2, int cantPeriodos, Usuario usuario) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(cantPeriodos);
		Collection<Integer> resultados = new ArrayList<>();
		try {
			periodos.stream().forEach((periodo) -> resultados.add(this.aplicarEnUnPeriodo(condicionPrioritaria, empresa1, empresa2, periodo, usuario)));
			if (resultados.stream().allMatch((unResultado) -> unResultado == 1))
				return 1;
			else if (resultados.stream().allMatch((unResultado) -> unResultado == -1))
				return -1;
			else
				return 0;
		}catch (Exception e){
			return -1;
		}
	}

	private Integer aplicarEnUnPeriodo(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2, Periodo periodo, Usuario usuario) {
		return condicionPrioritaria.comparar(condicionPrioritaria.aplicarIndicador(empresa1, periodo, usuario),
				condicionPrioritaria.aplicarIndicador(empresa2, periodo, usuario));
	}

	@Override
	public boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa, int cantPeriodos, Usuario usuario) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(cantPeriodos);
		Collection<Boolean> resultados = new ArrayList<>();
		periodos.stream().forEach((periodo) -> resultados.add(condicionTaxativa.comparar(condicionTaxativa.aplicarIndicador(empresa, periodo, usuario))));
		condicionTaxativa.reiniciar();
		return resultados.stream().allMatch((unResultado) -> unResultado == true);
	}
}
