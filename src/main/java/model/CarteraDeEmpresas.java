package model;

import java.util.Collection;

public class CarteraDeEmpresas {
	private static CarteraDeEmpresas instance = null;
	private Collection<Empresa> empresas;
	
	private CarteraDeEmpresas() {
		
	}
	
	public static CarteraDeEmpresas getInstance() {
		if(instance == null) {
			instance = new CarteraDeEmpresas();
		}
		return instance;
	}

	public Collection<Empresa> getEmpresas() {
		return empresas;
	}
	
	public void setEmpresas(Collection<Empresa> empresas) {
		this.empresas = empresas;
	}
}
