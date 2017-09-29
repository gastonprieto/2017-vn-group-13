package model.condiciones.taxativas;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.formas.de.aplicacion.AplicacionForma;
import model.formas.de.aplicacion.FormaAplicacion;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CondicionTaxativa  {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade = CascadeType.PERSIST)
	protected Indicador indicador;

	@OneToOne(cascade = CascadeType.PERSIST)
	protected CondicionTaxativa siguienteCondicion;

	@Enumerated(EnumType.ORDINAL)
	protected AplicacionForma aplicacionForma;
	
	@Transient
	protected FormaAplicacion formaAplicacion;
		
	protected int cantPeriodos;
	
	protected double valorReferencia;

	public CondicionTaxativa(){}

	public List<Empresa> filtrar(Collection<Empresa> empresas) {
			List<Empresa> empresasSeleccionadas = empresas.stream().filter((empresa) ->
					this.formaAplicacion.aplicarFiltro(this, empresa, this.cantPeriodos))
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
