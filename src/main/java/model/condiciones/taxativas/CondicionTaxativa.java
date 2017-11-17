package model.condiciones.taxativas;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.Usuario;
import model.formas.de.aplicacion.FormaAplicacionEnum;
import repositorios.RepositorioDeIndicadores;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CondicionTaxativa  {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	protected Indicador indicador;

	@OneToOne(cascade = CascadeType.PERSIST)
	protected CondicionTaxativa siguienteCondicion;

	@Enumerated(EnumType.STRING)
	protected FormaAplicacionEnum formaAplicacion;
		
	protected int cantPeriodos;
	
	protected double valorReferencia;

	public CondicionTaxativa() {}

	public List<Empresa> filtrar(Collection<Empresa> empresas, Usuario usuario) {
			List<Empresa> empresasSeleccionadas = empresas.stream().filter((empresa) ->
				this.formaAplicacion.getInstance()
					.aplicarFiltro(this, empresa, this.cantPeriodos, usuario)).collect(Collectors.toList());
		if(siguienteCondicion == null)
			return empresasSeleccionadas;
		else
			return siguienteCondicion.filtrar(empresasSeleccionadas, usuario);
	}
	
	public double aplicarIndicador(Empresa empresa, Periodo periodo, Usuario usuario) {
		return RepositorioDeIndicadores.getInstance().buscarIndicador(indicador.getNombre(), usuario).aplicar(empresa, periodo, usuario);
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
