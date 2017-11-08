package repositorios;

import javax.persistence.EntityManager;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import model.Usuario;

public class RepositorioDeUsuarios {

	private static RepositorioDeUsuarios instance = null;
	private EntityManager entityManager = PerThreadEntityManagers.getEntityManager();
	
	private RepositorioDeUsuarios() {}
	
	public static RepositorioDeUsuarios getInstance() {
		if(instance == null) {
			instance = new RepositorioDeUsuarios();
		}
		return instance;
	}
	
	public Usuario buscarUsuario(String username) {
		return entityManager.find(Usuario.class, username);
	}
}
