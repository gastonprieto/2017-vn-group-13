package model.condiciones.taxativas;

import model.formas.de.aplicacion.FormaAplicacion;
import model.Empresa;
import model.Indicador;
import model.Periodo;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CondicionTaxativa  {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Transient
	protected Indicador indicador;
	
	@Transient
	protected CondicionTaxativa siguienteCondicion;

	@Transient
	protected FormaAplicacion formaAplicacion;
	
	protected double valorReferencia;
	
	public CondicionTaxativa() {}
	
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
	
	public CondicionTaxativa getSiguienteCondicion() {
		return siguienteCondicion;
	}

	public void setSiguienteCondicion(CondicionTaxativa siguienteCondicion) {
		this.siguienteCondicion = siguienteCondicion;
	}
}
