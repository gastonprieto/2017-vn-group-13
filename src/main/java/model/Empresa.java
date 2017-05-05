package model;

import java.util.List;

import org.uqbar.commons.utils.Observable;

@Observable
public class Empresa {
	private String name;
	private List<Cuenta> cuentas;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
}
