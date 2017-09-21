package model.condiciones.prioritarias;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.*;

import model.Empresa;
import model.Indicador;
import model.Periodo;
import model.formas.de.aplicacion.FormaAplicacion;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class CondicionPrioritaria  {
	
	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade = CascadeType.PERSIST)
	protected Indicador indicador;

	@OneToOne(cascade = CascadeType.PERSIST)
	protected CondicionPrioritaria condicionDesempate;

	@Embedded
	protected FormaAplicacion formaAplicacion;
	
	@Column
	protected int cantPeriodos;

	public CondicionPrioritaria() {}
	
	public List<Empresa> ordenar(Collection<Empresa> collection) {
		return collection.stream().sorted((empresa1, empresa2) -> this.realizarComparacion(empresa1, empresa2)).collect(Collectors.toList());
	}
	
	public int realizarComparacion(Empresa empresa1, Empresa empresa2) {
		int resultado = this.formaAplicacion.aplicarPrioridad(this, empresa1, empresa2, this.cantPeriodos);
		if(resultado == 0 && condicionDesempate != null) {
			return condicionDesempate.realizarComparacion(empresa1, empresa2);
		}
		return resultado;
	}
	
	public double aplicarIndicador(Empresa empresa, Periodo periodo) {
		try {
			return this.indicador.aplicar(empresa, periodo);
		}catch (Exception e){
			return 0.0;
		}
	}
	
	public abstract int comparar(double resultadoEmpresa1, double resultadoEmpresa2);
	
	public void setCondicionDesempate(CondicionPrioritaria condicionDesempate) {
		this.condicionDesempate = condicionDesempate;
	}
	
	public CondicionPrioritaria getCondicionDesempate() {
		return condicionDesempate;
	}
}
