package Repositorio;


import model.Indicador;
import model.Metodologia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

public class RepositorioDeMetodologias {
    private static RepositorioDeMetodologias instance = null;
    private Collection<Metodologia> metodologias;

    private RepositorioDeMetodologias() {
        metodologias = new ArrayList<>();
    }

    public static RepositorioDeMetodologias getInstance() {
        if(instance == null) {
            instance = new RepositorioDeMetodologias();
        }
        return instance;
    }    

	public void registrarMetodologia(Metodologia metodologia) {        
		this.PerisistrMetodologiaDelRepositorio(metodologia);
		this.metodologias.add(metodologia);
	}
	
	public void PerisistrMetodologiaDelRepositorio(Metodologia metodologia){
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		 entityManager.getTransaction().begin();
		 entityManager.persist(metodologia);
		 entityManager.getTransaction().commit();
		 entityManager.close();
	 }
	
	public void LeerMetodologiasYCondicionesDeDB(){
		Collection<Metodologia> metodologiasYCondicionesLeidas = new ArrayList<Metodologia>();
		
		String consulta = "select e from model.Metodologia e";
		Query query = PerThreadEntityManagers.getEntityManager().createQuery(consulta);
		metodologiasYCondicionesLeidas = (Collection<Metodologia>) query.getResultList();
		
		this.setMetodologias(metodologiasYCondicionesLeidas);				
	}
    
    public Collection<Metodologia> getMetodologias() {
        return metodologias;
    }
    
    public void setMetodologias(Collection<Metodologia> metodologias) {
		this.metodologias = metodologias;
	}
}
