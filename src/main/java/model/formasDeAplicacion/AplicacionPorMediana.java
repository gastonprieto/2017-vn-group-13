package model.formasDeAplicacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import model.Empresa;
import model.Periodo;
import model.Condicion.Prioridad.CondicionPrioritaria;
import utils.Converts.GeneradorDePeriodos;

public class AplicacionPorMediana implements FormaAplicacion {
	
	private int cantPeriodos;
	
	public AplicacionPorMediana(int cantPeriodos) {
		this.cantPeriodos = cantPeriodos;
	}

	@Override
	public int aplicar(CondicionPrioritaria condicionPrioritaria, Empresa empresa1, Empresa empresa2) {
		Collection<Periodo> periodos = GeneradorDePeriodos.generarPeriodos(this.cantPeriodos);
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

}
