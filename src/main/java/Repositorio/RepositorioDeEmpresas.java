package Repositorio;

import model.Empresa;

import java.util.Collection;

public class RepositorioDeEmpresas {
	private static RepositorioDeEmpresas instance = null;
	private Collection<Empresa> empresas;
	
	private RepositorioDeEmpresas() {
		
	}
	
	public static RepositorioDeEmpresas getInstance() {
		if(instance == null) {
			instance = new RepositorioDeEmpresas();
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

