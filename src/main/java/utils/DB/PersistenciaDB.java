package utils.DB;

import java.util.Collection;

import javax.persistence.EntityManager;

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
	
	public void persistirMetodologiaYCondiciones() {
		entityManager.getTransaction().begin();	
		
		/*Collection<Metodologia> metodologias = RepositorioDeMetodologias.getInstance().getMetodologias();
		
		for(Metodologia metodologia : metodologias){ 	
			entityManager.persist(metodologia);	 		
		}	*/
		
		InterpretadorDeIndicadores interpretadorDeIndicadores = new InterpretadorDeIndicadores();
		
		Indicador nivelDeDeuda = interpretadorDeIndicadores.interpretar("Nivel de deuda", "Cuenta 3");
		FormaAplicacion aplicacionSimple = new AplicacionSimple();
		CondicionPrioritaria minimizarNivelDeDeuda = new CondicionMenorPrioritaria(nivelDeDeuda, aplicacionSimple, null);
		
		Indicador roe = interpretadorDeIndicadores.interpretar("ROE", "Cuenta 2");
		FormaAplicacion aplicacionPorConsistencia = new AplicacionPorConsistencia(5);
		CondicionPrioritaria maximizarROE = new CondicionMayorPrioritaria(roe, aplicacionPorConsistencia, minimizarNivelDeDeuda);
		
		Indicador margenes = interpretadorDeIndicadores.interpretar("Margenes", "Cuenta 1");
		CondicionTaxativa margenesConsistentementeCrecientes = new CondicionCrecienteTaxativa(margenes, null, 5);
		
		Metodologia metodologiaWarrenBuffet = new Metodologia("Warren Buffet", maximizarROE, margenesConsistentementeCrecientes);			
		
		entityManager.persist(metodologiaWarrenBuffet);
		
		entityManager.getTransaction().commit(); 	    
		entityManager.close();
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


}
