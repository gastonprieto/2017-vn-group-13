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

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (!Empresa.class.isAssignableFrom(obj.getClass())) {
			return false;
		}

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
