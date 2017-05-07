package model;

import java.util.Collection;

import org.uqbar.commons.utils.Observable;

@Observable
public class Empresa {
	private String name;
	private Collection<Cuenta> cuentas;
	
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
