package repositorios;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import model.Resultado;

public class RepositorioDeResultados {
	
	private static RepositorioDeResultados instance = null;
	
	private RepositorioDeResultados() {}
	
	public static RepositorioDeResultados getInstance() {
		if(instance == null) {
			instance = new RepositorioDeResultados();
		}
		return instance;
	}

	public void registrarResultado(Resultado resultado){
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(resultado);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Resultado> buscarTodos(){
		String consulta = "select e from model.Resultado e";
		Query query = PerThreadEntityManagers.getEntityManager().createQuery(consulta);
		return (Collection<Resultado>) query.getResultList();
	}

	public Resultado buscarResultado(long id) {
		return PerThreadEntityManagers.getEntityManager().find(Resultado.class, id);
	}

}
