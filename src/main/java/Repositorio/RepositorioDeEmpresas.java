package Repositorio;

import model.Empresa;
import utils.DB.PersistenciaDB;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class RepositorioDeEmpresas {
	private static RepositorioDeEmpresas instance = null;
	private Collection<Empresa> empresas;
	public EntityManager entityManager;
	
	private RepositorioDeEmpresas() {
		entityManager = PerThreadEntityManagers.getEntityManager(); 
	}

	
	public static RepositorioDeEmpresas getInstance() {
		if(instance == null) {
			instance = new RepositorioDeEmpresas();
			//PersistenciaDB persistencia = new PersistenciaDB();
			instance.setEmpresas(instance.LeerEmpresasDeDB());
		}
		return instance;
	}

	public Collection<Empresa> getEmpresas() {
		return empresas;
	}
	
	public void setEmpresas(Collection<Empresa> empresas) {
		this.empresas = empresas;
		//this.PerisistrEmprasasDelRepositorio(empresas);
	}
	
	public void PerisistrEmprasasDelRepositorio(Collection<Empresa> empresas){
		entityManager.getTransaction().begin();
		for(Empresa empresa : empresas){
			entityManager.persist(empresa);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public Collection<Empresa> LeerEmpresasDeDB(){
		Collection<Empresa> empresasLeidas = new ArrayList<Empresa>();			
		
		String consulta = "select e from model.Empresa e";
		Query query = entityManager.createQuery(consulta);
		empresasLeidas = (Collection<Empresa>) query.getResultList();			
		
		return empresasLeidas;		
	}
	
	
}

