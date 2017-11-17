package repositorios;

import model.Cuenta;
import model.Empresa;
import model.Periodo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import exception.EmpresaException;

public class RepositorioDeEmpresas {
	
	private static RepositorioDeEmpresas instance = null;

	private RepositorioDeEmpresas() {}

	public static RepositorioDeEmpresas getInstance() {
		if(instance == null) {
			instance = new RepositorioDeEmpresas();
		}
		return instance;
	}
	
	public void perisistirEmpresas(Collection<Empresa> empresas) {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
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
		Query query = PerThreadEntityManagers.getEntityManager().createQuery(consulta);
		empresasLeidas = (Collection<Empresa>) query.getResultList();			
		
		return empresasLeidas;		
	}
	
	public Cuenta findCuentaByEmpresaAndPeriodoAndNombre(Empresa empresa, Periodo periodo, String nombre) {
		try {
			Query query = PerThreadEntityManagers.getEntityManager().createQuery("SELECT e FROM Cuenta AS e WHERE e.name = :name AND e.empresa = :empresa "
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

	public Collection<Cuenta> buscarCuentasPorEmpresa(long empresaID) {
		return PerThreadEntityManagers.getEntityManager().find(Empresa.class, empresaID).getCuentas();
	}

	public void guardarEmpresa(Empresa empresa) {
		try {
			EntityManager em = PerThreadEntityManagers.getEntityManager();
			Empresa empresaAnterior = buscarEmpresaPorNombre(empresa.getName());
			if(empresaAnterior != null) {
				if(!empresa.esIgualA(empresaAnterior)) {
					Query q = em.createQuery("UPDATE Empresa SET name = :name WHERE id = :id");
					q.setParameter("name", empresa.getName());
					q.setParameter("id", empresaAnterior.getId());
					q.executeUpdate();
					empresa.setId(empresaAnterior.getId());
				}
			} else {
				em.getTransaction().begin();
				em.persist(empresa);
				em.flush();
				em.getTransaction().commit();
				em.close();
			}
			
		} catch(PersistenceException e) {
			e.printStackTrace();
		}
	}

	private Empresa buscarEmpresaPorNombre(String name) {
		EntityManager em = PerThreadEntityManagers.getEntityManager();
		Query q = em.createQuery("SELECT e FROM Empresa AS e WHERE e.name = :name");
		q.setParameter("name", name);
		try {
			return (Empresa) q.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}

