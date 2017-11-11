package repositorios;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import model.Metodologia;

public class RepositorioDeMetodologias {
	
    private static RepositorioDeMetodologias instance = null;

    private RepositorioDeMetodologias() {}

    public static RepositorioDeMetodologias getInstance() {
        if(instance == null) {
            instance = new RepositorioDeMetodologias();
        }
        return instance;
    }    

	public void registrarMetodologia(Metodologia metodologia){
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(metodologia);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Metodologia> buscarTodas(){
		String consulta = "select e from model.Metodologia e";
		Query query = PerThreadEntityManagers.getEntityManager().createQuery(consulta);
		return (Collection<Metodologia>) query.getResultList();
	}

	public Metodologia buscarMetodologia(long id) {
		return PerThreadEntityManagers.getEntityManager().find(Metodologia.class, id);
	}
}
