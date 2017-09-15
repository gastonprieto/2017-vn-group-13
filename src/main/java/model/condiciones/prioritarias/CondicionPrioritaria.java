package model.condiciones.prioritarias;

import model.Empresa;
import model.Indicador;
import model.Metodologia;
import model.Periodo;
import model.formas.de.aplicacion.AplicacionPorConsistencia;
import model.formas.de.aplicacion.FormaAplicacion;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CondicionPrioritaria  {
	
	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	protected Indicador indicador;

	@Transient
	protected CondicionPrioritaria condicionDesempate;

	@Embedded
	protected FormaAplicacion formaAplicacion;


	public CondicionPrioritaria() {}
	
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
	
	public void setCondicionDesempate(CondicionPrioritaria condicionDesempate) {
		this.condicionDesempate = condicionDesempate;
	}
	
	public CondicionPrioritaria getCondicionDesempate() {
		return condicionDesempate;
	}
}
