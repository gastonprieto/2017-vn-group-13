package model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.uqbar.commons.utils.Observable;

@Entity
@Observable
public class Empresa {
	
	@Id
	@GeneratedValue
	private Long id;

	@Column(length = 50)
	private String name;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "empresa", fetch = FetchType.EAGER)
	private Collection<Cuenta> cuentas;
	
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
}
