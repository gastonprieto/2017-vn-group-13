package model.condiciones.taxativas;

import model.formas.de.aplicacion.FormaAplicacion;
import model.Empresa;
import model.Indicador;
import model.Periodo;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CondicionTaxativa  {
	
	protected Indicador indicador;
	protected CondicionTaxativa siguienteCondicion;
	protected FormaAplicacion formaAplicacion;
	protected double valorReferencia;
	
	public List<Empresa> filtrar(List<Empresa> empresas) {
		List<Empresa> empresasSeleccionadas = empresas.stream().filter((empresa) -> this.formaAplicacion.aplicarFiltro(this, empresa))
				.collect(Collectors.toList());
		if(siguienteCondicion == null)
			return empresasSeleccionadas;
		else
			return siguienteCondicion.filtrar(empresasSeleccionadas);
	}
	
	public double aplicarIndicador(Empresa empresa, Periodo periodo) {
		return this.indicador.aplicar(empresa, periodo);
	}
	
	public abstract boolean comparar(double resultado);

	public void reiniciar() {
		// Se sobreescribe en creciente y decreciente
	}
}
