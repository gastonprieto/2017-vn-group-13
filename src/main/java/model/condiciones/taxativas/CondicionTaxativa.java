package model.condiciones.taxativas;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.formas.de.aplicacion.FormaAplicacion;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CondicionTaxativa  {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	protected Indicador indicador;

	@Transient
	protected CondicionTaxativa siguienteCondicion;

	@Embedded
	protected FormaAplicacion formaAplicacion;

	@Column
	protected double valorReferencia;

	public CondicionTaxativa(){}

	public List<Empresa> filtrar(Collection<Empresa> empresas) {
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
