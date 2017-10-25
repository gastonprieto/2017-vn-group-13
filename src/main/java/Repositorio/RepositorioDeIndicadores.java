package Repositorio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import exception.IndicadorException;
import model.Indicador;
import utils.File.InterpretadorDeIndicadores;

public class RepositorioDeIndicadores {
	private static RepositorioDeIndicadores instance = null;
	private Collection<Indicador> indicadores = new ArrayList<>();
	public EntityManager entityManager;
	
	private RepositorioDeIndicadores() {
		entityManager = PerThreadEntityManagers.getEntityManager();
	}
	
	public static RepositorioDeIndicadores getInstance() {
		if(instance == null) {
			instance = new RepositorioDeIndicadores();
		}
		return instance;
	}

	public void registrarIndicador(Indicador indicador) {
		if(this.buscarIndicador(indicador.getNombre()) != null) {
			throw new IndicadorException("El indicador ya existe");
		}
		
		this.PerisistrIndicadorDelRepositorio(indicador);

		indicadores.add(indicador);
	}
	
	public Collection<Indicador> getIndicadores() {
		return indicadores;
	}
	
	public void setIndicadores(Collection<Indicador> indicadores) {
		this.indicadores = indicadores;
	}
	
	public Collection<Indicador> LeerIndicadoresDeDB(){
		Collection<Indicador> indicadoresLeidos = new ArrayList<Indicador>();				
		
		String consulta = "select e from model.Indicador e";
		Query query = entityManager.createQuery(consulta);
		indicadoresLeidos = (Collection<Indicador>) query.getResultList();
		
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		return indicadoresLeidos.stream().map(indicador ->
			interpretador.interpretar(indicador.getNombre(), indicador.getOperacionPersistencia())).collect(Collectors.toList());
	}
	
	public void PerisistrIndicadorDelRepositorio(Indicador indicador){
		entityManager.getTransaction().begin();
		entityManager.persist(indicador);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public Indicador buscarIndicador(String nombre) {
		try {
			Query query = entityManager.createQuery("SELECT e FROM Indicador AS e WHERE e.nombre = :nombre", Indicador.class);
			query.setParameter("nombre", nombre);
			return (Indicador) query.getSingleResult();
		} catch(PersistenceException e) {
			throw new IndicadorException("No existe el indicador " + nombre);
		}
	}
	
}
