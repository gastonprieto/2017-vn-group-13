package repositorios;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import exception.IndicadorException;
import model.Indicador;
import utils.InterpretadorDeIndicadores;

public class RepositorioDeIndicadores {
	private static RepositorioDeIndicadores instance = null;
	
	private RepositorioDeIndicadores() {}
	
	public static RepositorioDeIndicadores getInstance() {
		if(instance == null) {
			instance = new RepositorioDeIndicadores();
		}
		return instance;
	}

	public void registrarIndicador(Indicador indicador) {
		if(this.buscarIndicadorPorNombre(indicador.getNombre()) != null) {
			throw new IndicadorException("El indicador ya existe");
		}
		this.persistirIndicador(indicador);
	}

	public Collection<Indicador> getIndicadores() {
		return this.buscarTodos();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Indicador> buscarTodos() {			
		String consulta = "select e from model.Indicador e";
		Query query = PerThreadEntityManagers.getEntityManager().createQuery(consulta);
		Collection<Indicador> indicadoresLeidos = (Collection<Indicador>) query.getResultList();
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		return indicadoresLeidos.stream().map(indicador ->
			interpretador.interpretar(indicador.getNombre(), indicador.getOperacionPersistencia())).collect(Collectors.toList());
	}
	
	public void persistirIndicador(Indicador indicador) {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(indicador);
		entityManager.getTransaction().commit();
	}
	
	public Indicador buscarIndicador(String nombre) {
		Indicador indicador = buscarIndicadorPorNombre(nombre);
		if(indicador != null) {
			return new InterpretadorDeIndicadores().interpretar(indicador.getNombre(), indicador.getOperacionPersistencia());
		}
		throw new IndicadorException("No existe el indicador " + nombre);
	}

	private Indicador buscarIndicadorPorNombre(String nombre) {
		Query query = PerThreadEntityManagers.getEntityManager().createQuery("SELECT e FROM Indicador AS e WHERE e.nombre = :nombre", Indicador.class);
		query.setParameter("nombre", nombre);
		try {
			return (Indicador) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}
}
