package model;

import java.util.Collection;

import javax.persistence.*;

import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;
import org.uqbar.commons.utils.Observable;

@Entity
@Observable
public class Metodologia {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 50)
	private String nombre;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private CondicionPrioritaria condicionPrioritaria;

	@OneToOne(cascade = CascadeType.PERSIST)
	private CondicionTaxativa condicionTaxativa;

	public Metodologia() {}
	
	public Metodologia(String nombre, CondicionPrioritaria condicionPrioritaria, CondicionTaxativa condicionTaxativa) {
		this.nombre = nombre;
		this.condicionPrioritaria = condicionPrioritaria;
		this.condicionTaxativa = condicionTaxativa;
	}
	
	public Collection<Empresa> evaluar(Collection<Empresa> empresas) {
		return this.ordenar(this.filtrar(empresas));
	}
	
	public Collection<Empresa> filtrar(Collection<Empresa> empresas) {
		if(this.condicionTaxativa != null)
			return this.condicionTaxativa.filtrar(empresas);
		return empresas;
	}
	
	public Collection<Empresa> ordenar(Collection<Empresa> collection) {
		if(this.condicionPrioritaria != null)
			return this.condicionPrioritaria.ordenar(collection);
		return collection;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
