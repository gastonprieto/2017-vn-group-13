package viewmodel;

import org.uqbar.commons.utils.Observable;

import model.builders.MetodologiaBuilder;

@Observable
public class CrearMetodologiaViewModel {

	private String nombre;

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public MetodologiaBuilder getBuilder() {
		return new MetodologiaBuilder(this.nombre);
	}
}
