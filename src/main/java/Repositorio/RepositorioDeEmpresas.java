package Repositorio;

import model.Cuenta;
import model.Empresa;
import model.Periodo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import exception.EmpresaException;

public class RepositorioDeEmpresas {
	
	private static RepositorioDeEmpresas instance = null;
	private Collection<Empresa> empresas;
	public EntityManager entityManager;
	
	private RepositorioDeEmpresas() {
		entityManager = PerThreadEntityManagers.getEntityManager();
		empresas = buscarTodas();
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
	
	public void perisistirEmpresas(Collection<Empresa> empresas){
		entityManager.getTransaction().begin();
		for(Empresa empresa : empresas){
			entityManager.persist(empresa);
		}
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Empresa> buscarTodas(){
		Collection<Empresa> empresasLeidas = new ArrayList<Empresa>();			
		
		String consulta = "select e from model.Empresa e";
		Query query = entityManager.createQuery(consulta);
		empresasLeidas = (Collection<Empresa>) query.getResultList();			
		
		return empresasLeidas;		
	}
	
	public Cuenta findCuentaByEmpresaAndPeriodoAndNombre(Empresa empresa, Periodo periodo, String nombre) {
		try {
			Query query = entityManager.createQuery("SELECT e FROM Cuenta AS e WHERE e.name = :name AND e.empresa = :empresa "
					+ "AND e.periodo.year = :year AND e.periodo.semester = :semester", Cuenta.class);
		   query.setParameter("name", nombre);
		   query.setParameter("empresa", empresa);
		   query.setParameter("year", periodo.getYear());
		   query.setParameter("semester", periodo.getSemester());
		   return (Cuenta) query.getSingleResult();
		} catch(PersistenceException e) {
			throw new EmpresaException("La empresa " + empresa.getName() + " no posee la cuenta " + nombre +
					" en el semestre " + periodo.getSemester() + " del " + periodo.getYear());
		}
	}
}

