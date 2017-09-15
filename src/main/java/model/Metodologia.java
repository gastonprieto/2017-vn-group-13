package model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;

@Entity
public class Metodologia {

	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 50)
	private String nombre;

	@OneToOne
	@JoinColumn(name = "id_primer_condicion_prioritaria")
	private CondicionPrioritaria condicionPrioritaria;

	@OneToOne
	@JoinColumn(name = "id_primer_condicion_taxativa")
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
