package repositorios;

import java.util.Collection;

import org.uqbarproject.jpa.java8.extras.PerThreadEntityManagers;

import model.Usuario;

public class RepositorioDeUsuarios {

	private static RepositorioDeUsuarios instance = null;
	
	private RepositorioDeUsuarios() {}
	
	public static RepositorioDeUsuarios getInstance() {
		if(instance == null) {
			instance = new RepositorioDeUsuarios();
		}
		return instance;
	}
	
	public Usuario buscarUsuario(String username) {
		return PerThreadEntityManagers.getEntityManager().find(Usuario.class, username);
	}

	public Collection<Usuario> buscarTodos() {
		return null;
	}
}
