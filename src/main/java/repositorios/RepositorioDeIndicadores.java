package repositorios;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import exception.IndicadorException;
import model.Indicador;
import model.Usuario;
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

	public void registrarIndicador(Indicador indicador, Usuario usuario) {
		if(this.buscarIndicadorPorNombre(indicador.getNombre(), usuario) != null) {
			throw new IndicadorException("El indicador ya existe");
		}
		indicador.setUsuario(usuario);
		this.persistirIndicador(indicador);
	}

	public Collection<Indicador> getIndicadores(Usuario usuario) {
		return this.buscarTodos(usuario);
	}
	
	@SuppressWarnings("unchecked")
	public Collection<Indicador> buscarTodos(Usuario usuario) {			
		String consulta = "select e from model.Indicador e WHERE e.usuario = :usuario";
		Query query = PerThreadEntityManagers.getEntityManager().createQuery(consulta);
		query.setParameter("usuario", usuario);
		Collection<Indicador> indicadoresLeidos = (Collection<Indicador>) query.getResultList();
		return indicadoresLeidos.stream().map(indicador -> obtenerIndicadorInterpretado(indicador)).collect(Collectors.toList());
	}
	
	private Indicador obtenerIndicadorInterpretado(Indicador indicador) {
		InterpretadorDeIndicadores interpretador = new InterpretadorDeIndicadores();
		Indicador indicadorInterpretado = interpretador.interpretar(indicador.getNombre(), indicador.getOperacionPersistencia());
		indicadorInterpretado.setId(indicador.getId());
		return indicadorInterpretado;
	}

	public void persistirIndicador(Indicador indicador) {
		EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(indicador);
		entityManager.getTransaction().commit();
	}
	
	public Indicador buscarIndicador(String nombre, Usuario usuario) {
		Indicador indicador = buscarIndicadorPorNombre(nombre, usuario);
		if(indicador != null) {
			return new InterpretadorDeIndicadores().interpretar(indicador.getNombre(), indicador.getOperacionPersistencia());
		}
		throw new IndicadorException("No existe el indicador " + nombre);
	}

	private Indicador buscarIndicadorPorNombre(String nombre, Usuario usuario) {
		Query query = PerThreadEntityManagers.getEntityManager().createQuery("SELECT e FROM Indicador AS e WHERE e.nombre = :nombre AND e.usuario = :usuario", Indicador.class);
		query.setParameter("nombre", nombre);
		query.setParameter("usuario", usuario);
		try {
			return (Indicador) query.getSingleResult();
		} catch(NoResultException e) {
			return null;
		}
	}

	public Indicador buscarIndicadorPorId(long id) {
		return obtenerIndicadorInterpretado(PerThreadEntityManagers.getEntityManager().find(Indicador.class, id));
	}
}
