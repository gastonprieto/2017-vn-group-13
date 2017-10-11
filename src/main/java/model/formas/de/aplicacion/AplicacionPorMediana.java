package model.formas.de.aplicacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import model.Empresa;
import model.Periodo;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;
import utils.Converts.GeneradorDePeriodos;

public class AplicacionPorMediana extends FormaAplicacion {
	
	private static AplicacionPorMediana instance;
	
	public static AplicacionPorMediana getInstance() {
		if(instance == null)
			instance = new AplicacionPorMediana();
		return instance;
	}
	
	private AplicacionPorMediana() {}

	@Override
	public int aplicarPrioridad(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2, int cantPeriodos) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(cantPeriodos);
		Collection<Double> resultadosEmpresa1 = new ArrayList<>();
		Collection<Double> resultadosEmpresa2 = new ArrayList<>();
		periodos.stream().forEach((periodo) -> resultadosEmpresa1.add(condicionPrioritaria.aplicarIndicador(empresa1, periodo)));
		periodos.stream().forEach((periodo) -> resultadosEmpresa2.add(condicionPrioritaria.aplicarIndicador(empresa2, periodo)));
		double resultadoEmpresa1 = resultadosEmpresa1.stream()
				.sorted((resultado1, resultado2) -> Double.compare(resultado1, resultado2)).collect(Collectors.toList())
				.get(resultadosEmpresa1.size() / 2);
		double resultadoEmpresa2 = resultadosEmpresa2.stream()
				.sorted((resultado1, resultado2) -> Double.compare(resultado1, resultado2)).collect(Collectors.toList())
				.get(resultadosEmpresa2.size() / 2);
		return condicionPrioritaria.comparar(resultadoEmpresa1, resultadoEmpresa2);
	}

	@Override
	public boolean aplicarFiltro(CondicionTaxativa condicionTaxativa, Empresa empresa, int cantPeriodos) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(cantPeriodos);
		Collection<Double> resultados = new ArrayList<>();
		try {
			periodos.stream().forEach((periodo) -> resultados.add(condicionTaxativa.aplicarIndicador(empresa, periodo)));
			double mediana = resultados.stream()
				.sorted((resultado1, resultado2) -> Double.compare(resultado1, resultado2)).collect(Collectors.toList())
				.get(resultados.size() / 2);
			return condicionTaxativa.comparar(mediana);
		} catch(Exception e) {
			return  false;
		}
	}

}
