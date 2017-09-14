package viewmodel;

import org.uqbar.commons.utils.Observable;

import model.builders.MetodologiaBuilder;

@Observable
public class CrearCondicionViewModel {
	
	private MetodologiaBuilder builder;
	private int cantPeriodos;

	public MetodologiaBuilder getBuilder() {
		return this.builder;
	}

	public void crearMetodologia() {
		// TODO Auto-generated method stub
		
	}

	public int getCantPeriodos() {
		return cantPeriodos;
	}

	public void setCantPeriodos(int cantPeriodos) {
		this.cantPeriodos = cantPeriodos;
	}
}
