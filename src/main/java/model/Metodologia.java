package model;

import model.Condicion.Taxativa.CondicionTaxativa;
import model.condiciones.prioritarias.CondicionPrioritaria;

import java.util.List;

public class Metodologia {
	
	private String nombre;
	private CondicionPrioritaria condicionPrioritaria;
	private CondicionTaxativa condicionTaxativa;
	
	public Metodologia(String nombre, CondicionPrioritaria condicionPrioritaria) {
		this.nombre = nombre;
		this.condicionPrioritaria = condicionPrioritaria;
	}
	
	public List<Empresa> evaluar(List<Empresa> empresas) {
		return this.condicionPrioritaria.ordenar(this.condicionTaxativa.filtrar(empresas));
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
