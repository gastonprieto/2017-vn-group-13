package utils.DB;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Empresa;
import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import Repositorio.RepositorioDeMetodologias;
import model.Indicador;
import model.Metodologia;
import model.condiciones.prioritarias.CondicionMayorPrioritaria;
import model.condiciones.prioritarias.CondicionMenorPrioritaria;
import model.condiciones.prioritarias.CondicionPrioritaria;
import model.condiciones.taxativas.CondicionCrecienteTaxativa;
import model.condiciones.taxativas.CondicionTaxativa;
import model.formas.de.aplicacion.AplicacionPorConsistencia;
import model.formas.de.aplicacion.AplicacionSimple;
import model.formas.de.aplicacion.FormaAplicacion;
import utils.File.InterpretadorDeIndicadores;

public class PersistenciaDB {
	
	private EntityManager entityManager;
	
	public PersistenciaDB() { 		
		entityManager = PerThreadEntityManagers.getEntityManager(); 	
	} 	 	

	 public void PerisistrMetodologiaDelRepositorio(Metodologia metodologia){
		 entityManager.getTransaction().begin();
		 entityManager.persist(metodologia);
		 entityManager.getTransaction().commit();
		 entityManager.close();
	 }

	public void PerisistrIndicadorDelRepositorio(Indicador indicador){
		entityManager.getTransaction().begin();
		entityManager.persist(indicador);
		entityManager.getTransaction().commit();
		entityManager.close();
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
	
	public Collection<Indicador> LeerIndicadoresDeDB(){
		Collection<Indicador> indicadoresLeidos = new ArrayList<Indicador>();				
		
		String consulta = "select e from model.Indicador e";
		Query query = entityManager.createQuery(consulta);
		indicadoresLeidos = (Collection<Indicador>) query.getResultList();
		
		return indicadoresLeidos;		
	}
	
	public Collection<Metodologia> LeerMetodologiasYCondicionesDeDB(){
		Collection<Metodologia> metodologiasYCondicionesLeidas = new ArrayList<Metodologia>();
		
		String consulta = "select e from model.Metodologia e";
		Query query = entityManager.createQuery(consulta);
		metodologiasYCondicionesLeidas = (Collection<Metodologia>) query.getResultList();
		
		return metodologiasYCondicionesLeidas;		
	}

}
