package model.Condicion.Prioridad;


import model.Empresa;
import model.Indicador;
import model.Periodo;
import org.uqbar.commons.utils.Observable;

import java.util.Collection;


@Observable
public class CondicionDecreciente extends CondicionCreciente {

	public CondicionDecreciente(String name, Indicador indicador, int cantidadDePeriodos){
		this.name = name;
		this.indicador = indicador;
		this.cantidadDePeriodos = cantidadDePeriodos;
	}

	@Override
	public int comparar(Empresa empresa1, Empresa empresa2, Collection<Periodo> periodos) {
		return super.comparar(empresa1, empresa2, periodos); // Deberia poder aplicar una funcion que invierta el resultado de super
	}
}