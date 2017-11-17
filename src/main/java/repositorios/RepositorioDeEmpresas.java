package repositorios;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import exception.EmpresaException;
import model.Cuenta;
import model.Empresa;
import model.Periodo;

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
		Cuenta cuenta = findCuenta(empresa, periodo, nombre);
		if(cuenta != null) {
			return cuenta;
		}
		throw new EmpresaException("La empresa " + empresa.getName() + " no posee la cuenta " + nombre +
				" en el semestre " + periodo.getSemester() + " del " + periodo.getYear());
	}

	private Cuenta findCuenta(Empresa empresa, Periodo periodo, String nombre) {
		try {
			Query query = PerThreadEntityManagers.getEntityManager().createQuery("SELECT e FROM Cuenta AS e WHERE e.name = :name AND e.empresa = :empresa "
					+ "AND e.periodo.year = :year AND e.periodo.semester = :semester", Cuenta.class);
			query.setParameter("name", nombre);
			query.setParameter("empresa", empresa);
			query.setParameter("year", periodo.getYear());
			query.setParameter("semester", periodo.getSemester());
			return (Cuenta) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

	public Collection<Cuenta> buscarCuentasPorEmpresa(long empresaID) {
		return PerThreadEntityManagers.getEntityManager().find(Empresa.class, empresaID).getCuentas();
	}

	public void guardarEmpresa(Empresa empresa) {
		try {
			EntityManager em = PerThreadEntityManagers.getEntityManager();
			Empresa empresaAnterior = buscarEmpresaPorNombre(empresa.getName());
			if(empresaAnterior == null) {
				empresa.getCuentas().stream().forEach(cuenta -> cuenta.setEmpresa(empresa));
				em.getTransaction().begin();
				em.persist(empresa);
				em.flush();
				em.getTransaction().commit();
				em.close();
			} else {
				empresa.getCuentas().stream().forEach(cuenta -> actualizarCuenta(empresaAnterior, cuenta));
			}
		} catch(PersistenceException e) {
			e.printStackTrace();
		}
	}

	private void actualizarCuenta(Empresa empresa, Cuenta cuenta) {
		EntityManager em = PerThreadEntityManagers.getEntityManager();
		Cuenta cuentaAnterior = findCuenta(empresa, cuenta.getPeriodo(), cuenta.getName());
		if(cuentaAnterior == null) {
			cuenta.setEmpresa(empresa);
			em.getTransaction().begin();
			em.persist(empresa);
			em.flush();
			em.getTransaction().commit();
			em.close();
		} else if(cuentaAnterior.getValue() != cuenta.getValue()) {
			em.getTransaction().begin();
			Query q = em.createQuery("UPDATE Cuenta SET value = :value WHERE id = :id");
			q.setParameter("value", cuenta.getValue());
			q.setParameter("id", cuentaAnterior.getId());
			q.executeUpdate();
			em.getTransaction().commit();
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

	public Empresa buscarEmpresaPorId(long id) {
		return PerThreadEntityManagers.getEntityManager().find(Empresa.class, id);
	}
}

