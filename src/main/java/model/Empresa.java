package model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.uqbar.commons.utils.Observable;

import exception.EmpresaException;

@Entity
@Observable
public class Empresa {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 50)
	private String name;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "empresa")
	private Collection<Cuenta> cuentas;
	
	public Double buscarValorDeCuentaParaPeriodo(String nombre, Periodo periodoTarget) {
		for(Cuenta cuenta : cuentas) {
			if(cuenta.getName().equalsIgnoreCase(nombre) && cuenta.getPeriodo().equals(periodoTarget))
				return cuenta.getValue();
		}
		throw new EmpresaException("la empresa " + this.name + " no posee cuenta para el pediodo en el periodo: " + "A�o = " +
				periodoTarget.getYear() + " Semestre = " + periodoTarget.getSemester());
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Collection<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!Empresa.class.isAssignableFrom(obj.getClass()))
			return false;
		final Empresa empresaAComparar = (Empresa) obj;
		if (!this.name.equals(empresaAComparar.name))
			return false;			
		for (Cuenta cuentaAComparar : empresaAComparar.cuentas) {
			if (!cuentas.contains(cuentaAComparar))
				return false;		
		}		
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);		
		return hash;
	}
}
