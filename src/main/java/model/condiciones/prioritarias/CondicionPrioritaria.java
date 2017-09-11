package model.condiciones.prioritarias;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.formas.de.aplicacion.FormaAplicacion;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CondicionPrioritaria  {
	
	protected Indicador indicador;
	protected CondicionPrioritaria condicionDesempate;
	protected FormaAplicacion formaAplicacion;
	
	public List<Empresa> ordenar(List<Empresa> empresas) {
		return empresas.stream().sorted((empresa1, empresa2) -> this.realizarComparacion(empresa1, empresa2)).collect(Collectors.toList());
	}
	
	public int realizarComparacion(Empresa empresa1, Empresa empresa2) {
		int resultado = this.formaAplicacion.aplicarPrioridad(this, empresa1, empresa2);
		if(resultado == 0 && condicionDesempate != null) {
			return condicionDesempate.realizarComparacion(empresa1, empresa2);
		}
		return resultado;
	}
	
	public double aplicarIndicador(Empresa empresa, Periodo periodo) {
		return this.indicador.aplicar(empresa, periodo);
	}
	
	public abstract int comparar(double resultadoEmpresa1, double resultadoEmpresa2);
}
