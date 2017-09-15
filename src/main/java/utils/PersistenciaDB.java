package utils;

/**
 * Created by rapap on 13/09/2017.
 */


import java.util.Collection;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Repositorio.RepositorioDeMetodologias;
import model.Metodologia;
public class PersistenciaDB {

    private EntityManager entityManager;

    public PersistenciaDB() {
        entityManager = PerThreadEntityManagers.getEntityManager();
    }

    public void persistirMetodologiaYCondiciones() {

        entityManager.getTransaction().begin();
        Collection<Metodologia> metodologias = RepositorioDeMetodologias.getInstance().getMetodologias();

        for(Metodologia metodologia : metodologias){
            entityManager.persist(metodologia);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void persistirEmpresasYCuentas() {

    }

    public void persistirIndicadores() {

    }
}
