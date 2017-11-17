package model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionTaxativa;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "nombre"}))
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
	
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

	public Metodologia() {}
	
	public Metodologia(String nombre, CondicionPrioritaria condicionPrioritaria, CondicionTaxativa condicionTaxativa) {
		this.nombre = nombre;
		this.condicionPrioritaria = condicionPrioritaria;
		this.condicionTaxativa = condicionTaxativa;
	}
	
	public Collection<Empresa> evaluar(Collection<Empresa> empresas) {
		return this.ordenar(this.filtrar(empresas, this.usuario), this.usuario);
	}
	
	public Collection<Empresa> filtrar(Collection<Empresa> empresas, Usuario usuario) {
		if(this.condicionTaxativa != null)
			return this.condicionTaxativa.filtrar(empresas, usuario);
		return empresas;
	}
	
	public Collection<Empresa> ordenar(Collection<Empresa> collection, Usuario usuario) {
		if(this.condicionPrioritaria != null)
			return this.condicionPrioritaria.ordenar(collection, usuario);
		return collection;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Long getId() {
		return id;
	}
}
