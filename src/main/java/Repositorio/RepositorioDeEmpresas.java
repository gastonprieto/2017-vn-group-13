package Repositorio;

import model.Empresa;
import utils.DB.PersistenciaDB;

import java.util.Collection;

public class RepositorioDeEmpresas {
	private static RepositorioDeEmpresas instance = null;
	private Collection<Empresa> empresas;
	
	private RepositorioDeEmpresas() {
		
	}
	
	public static RepositorioDeEmpresas getInstance() {
		if(instance == null) {
			instance = new RepositorioDeEmpresas();
			//PersistenciaDB persistencia = new PersistenciaDB();
			//instance.setEmpresas(persistencia.LeerEmpresasDelRepositorio());
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

