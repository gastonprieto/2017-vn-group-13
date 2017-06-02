package model;

import java.util.ArrayList;
import java.util.Collection;

import exception.IndicadorException;

public class RepositorioDeIndicadores {
	private static RepositorioDeIndicadores instance = null;
	private Collection<Indicador> indicadores = new ArrayList<>();
	
	private RepositorioDeIndicadores() {
		
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
		indicadores.add(indicador);
	}
	
	public Collection<Indicador> getIndicadores() {
		return indicadores;
	}

	public Indicador buscarIndicador(String nombre) {
		for(Indicador indicador : indicadores) {
			if(indicador.getNombre().equalsIgnoreCase(nombre)) {
				return indicador;
			}
		}
		return null;
	}
}
